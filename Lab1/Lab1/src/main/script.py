import threading

import requests


def execute_request(url, word, size):
    try:
        response = requests.get(
            url, data={"word": word, "size": size}, headers={"Accept": "text/plain"}
        )

        print(response.text)
    except Exception as e:
        print(e)


if __name__ == "__main__":
    for i in range(10):
        thread = threading.Thread(
            target=execute_request(
                "http://localhost:8080/Lab1-1.0-SNAPSHOT/handleWord?word=anagram&size=0",
                "anagram",
                0,
            )
        )
        thread.start()
