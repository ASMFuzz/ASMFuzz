import os
import sys
from pathlib import Path

BASE_DIR = str(Path(__file__).resolve().parent)
print(BASE_DIR)
sys.path.append(BASE_DIR)


class Django_work(object):

    @staticmethod
    def runShell(command):
        print(os.popen(command).read())

    def makemigrationsAndMigrate(self):
        self.runShell(
            'python {0} makemigrations && python {1} migrate'.format(os.path.join(BASE_DIR, "web/manage.py"),
                                                                     os.path.join(BASE_DIR, "web/manage.py")))

    def runserver(self):
        self.runShell('python {0} runserver 0.0.0.0:11100'.format(os.path.join(BASE_DIR, "web/manage.py")))

    def loaddata(self):
        self.runShell('python {0} loaddata initial_data.json'.format(BASE_DIR, os.path.join(BASE_DIR, "web/manage.py")))


class Menu(object):
    def __init__(self):
        self.django_work = Django_work()
        self.choices = {
            "1": self.django_work.makemigrationsAndMigrate,
            "2": self.django_work.runserver,
            "3": self.django_work.loaddata,
            "4": self.quit
        }

    def display_menu(self):
        print("""
操作菜单:
1. 同步数据库
2. 启动web服务器
3. 恢复差分引擎数据
4. 退出
""")

    def run(self):
        while True:
            self.display_menu()
            try:
                choice = input("您选择操作:  ")
                # choice = 2
            except Exception as e:
                print("请输入有效操作!");
                continue

            choice = str(choice).strip()
            action = self.choices.get(choice)
            if action:
                action()
                pass
            else:
                print("{0} 不是有效的选择".format(choice))

    def quit(self):
        print("\n谢谢使用!\n")
        sys.exit(0)


if __name__ == '__main__':
    Menu().run()
