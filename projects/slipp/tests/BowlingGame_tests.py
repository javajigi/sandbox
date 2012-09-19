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
	assert_equals(game.get_total_score(), 10)
	game.roll(5)
	assert_equals(game.get_total_score(), 20)
	game.roll(3) # gutter
	assert_equals(game.get_total_score(), 23)

def test_roll_strike():
	game = BowlingGame()
	game.roll(10) #strike
	game.roll(8)
	game.roll(1)
	assert_equals(game.get_total_score(), 28)

def test_roll_strike_strike():
	game = BowlingGame()
	game.roll(10) #strike
	assert_equals(game.get_total_score(), 10)
	game.roll(10)
	assert_equals(game.get_total_score(), 30)
	game.roll(8)
	assert_equals(game.get_total_score(), 54)
	game.roll(1)
	assert_equals(game.get_total_score(), 56)

def test_roll_ten_frame():
	game = BowlingGame()
	for i in range(0, 12):
		game.roll(10)
	assert_equals(game.get_total_score(), 300)

	game = BowlingGame()
	for i in range(0, 11):
		game.roll(3)
	assert_equals(game.get_total_score(), 33)
