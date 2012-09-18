from nose.tools import *
from slipp.game import BowlingGame 

def setup():
	print "SETUP!"    

def teardown():
    print "TEAR DOWN!"

def test_roll_gutter():
	game = BowlingGame()	
	game.roll(8)
	assert_equals(game.get_total_score(), 8)
	game.roll(0) # gutter
	
	game.roll(7)
	assert_equals(game.get_total_score(), 15)

def test_roll_spare():
	game = BowlingGame()
	game.roll(8)
	game.roll(2) # spare
	game.roll(5)
	assert_equals(game.get_total_score(), 15)
	game.roll(3) # gutter
	assert_equals(game.get_total_score(), 23)
	
	