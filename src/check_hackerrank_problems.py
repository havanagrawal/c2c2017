"""A short script to retrieve HackerRank details for a set of users

This uses an unofficial, non-public URL to retrieve details.
I have added a deliberate delay so as to not over-burden the HackerRank servers
"""

import urllib, json
import os
from datetime import datetime
from time import sleep
import sys

HR_URL = "https://www.hackerrank.com/rest/hackers/{user}/recent_challenges?cursor={cursor}&limit=100&response_version=v2"

HR_FILE = "hackerrank_c2c2017.json"
SLEEP_TIME_IN_SECONDS = 5

class HackerRankProblem(object):
    def __init__(self, url, created_at, ch_slug, name, con_slug):
        self.url = url
        self.created_at = created_at
        self.ch_slug = ch_slug
        self.name = name
        self.con_slug = con_slug


def update_json(username):
    """Update our local JSON file with any new problems that user may have solved"""
    last_known_prob = get_last_known_solved(username)
    last_known_prob_name = None

    if last_known_prob:
        last_known_prob_name = last_known_prob['name']
        # print("Last known solved problem is " + last_known_prob_name)

    new_solved = []

    for prob in get_problems_from_hackerrank(username):
        if prob.name == last_known_prob_name:
            break

        new_solved.append(prob.__dict__)

    # print("{user} has solved {new_probs} new problems since last time!".format(user=username, new_probs=len(new_solved)))

    user_data = read_json_file()

    if username not in user_data:
        user_data[username] = []

    user_data[username] = new_solved + user_data[username]

    write_json_file(user_data)

    return (last_known_prob_name, len(new_solved))


def get_last_known_solved(username):
    """Read the last entry from a JSON file for the user"""
    solved_problems = get_all_known_solved(username)

    if solved_problems:
        return solved_problems[0]


def get_all_known_solved(username):
    """Read all entries from a JSON file for the user"""

    all_user_data = read_json_file()

    if username not in all_user_data:
        return []

    user_data = all_user_data[username]

    if not user_data:
        return []

    return user_data


def get_problems_from_hackerrank(username):
    """Generator function that returns solved problems in descending order"""
    cursor = "null"

    while True:
        problems, cursor = _get_next_set_of_problems(username, cursor)

        for p in problems:
            hr_prob = HackerRankProblem(p['url'], p['created_at'], p['ch_slug'], p['name'], p['con_slug'])
            yield hr_prob

        if not cursor:
            return

def _get_next_set_of_problems(username, cursor):
    url = HR_URL.format(user=username, cursor=cursor)

    start_time = datetime.now()
    response = urllib.urlopen(url)
    end_time = datetime.now()

    total_seconds = (end_time - start_time).total_seconds()

    print("URL call took {} seconds".format(total_seconds))

    try:
        data = json.load(response)
    except ValueError as ve:
        print("ERROR: " + str(ve))
        print("We will try again later for {user}".format(user=username))
        return [], None

    problems = data['models']
    cursor = data['cursor']

    return problems, cursor


def read_json_file():
    if not os.path.exists(HR_FILE):
        return {}

    with open(HR_FILE, 'r') as json_file:
        user_data = json.load(json_file)

    return user_data


def write_json_file(user_data):
    """Write out the data to the json file"""
    with open(HR_FILE, 'w') as json_file:
        user_json = json.dumps(user_data)
        json_file.truncate()
        json_file.write(user_json)


def pretty_print_status_table(user_status):
    print("Username".ljust(25) + "\t|" +
          "Last Solved".ljust(50) + "\t|" +
          "#New Solved".ljust(10) + "\t|" +
          "Total Solved")

    sorted_user_status = sorted(user_status.items(), key=lambda x: x[1]["no_of_solved_total"])

    for username, status in sorted_user_status:
        last_known_prob_name = status["last_known_prob_name"].ljust(50)
        new_solved = str(status["new_solved"]).ljust(10)
        no_of_solved_total = str(status["no_of_solved_total"])

        print("{}\t|{}\t|{}\t|{}".format(username.ljust(25), last_known_prob_name, str(new_solved).ljust(10), no_of_solved_total))


def main():
    usernames = ["shahdhrumil1060", "kiran_jawahiran1", "urvi_gadda", "masiraansari62", "akshay_kamath", "cpt01", "parikhsagar073", "hvaidsain26", "vikrant51296", "revati0616", "deep20", "knaik", "a_agarwal_14", "sahil_mankad", "niharika_nahar", "suresh_bp", "bhakti12", "melvita_a", "Wazirabahnan3", "adi99ss", "ashanka_bhilare1", "dev69", "Bhakti_C", "priyanka_agarkar", "saketdmano", "rugnesh_k", "aakash216961", "AdiPadi3", "quickgun_ak47", "DevikaShanbhag", "Aishriya", "niyati_js", "gautami_shelar", "adepudivya96", "mihir_jethwa", "Havan"]

    user_status = {}

    if len(sys.argv) > 1:
        usernames = sys.argv[1:]

    for username in usernames:

        print("Checking status for {}".format(username))

        last_known_prob_name, new_solved = update_json(username)

        if last_known_prob_name is not None:
            last_known_prob_name = last_known_prob_name.ljust(40)
        else:
            last_known_prob_name = "None".ljust(40)

        no_of_solved_total = len(get_all_known_solved(username))

        user_status[username] = {
                "last_known_prob_name": last_known_prob_name,
                "no_of_solved_total": no_of_solved_total,
                "new_solved": new_solved
            }

        print("Sleeping for {} seconds".format(SLEEP_TIME_IN_SECONDS))
        sleep(SLEEP_TIME_IN_SECONDS)

    pretty_print_status_table(user_status)


if __name__ == '__main__':
    main()
