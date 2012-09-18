try:
    from setuptools import setup
except ImportError:
    from distutils.core import setup

config = {
    'description': 'My SLiPP',
    'author': 'JavaJiGi',
    'url': 'http://www.slipp.net',
    'download_url': 'http://www.slipp.net/downloads',
    'author_email': 'javajigi@gmail.com',
    'version': '0.1',
    'install_requires': ['nose'],
    'packages': ['slipp'],
    'scripts': [],
    'name': 'slipp'
}

setup(**config)