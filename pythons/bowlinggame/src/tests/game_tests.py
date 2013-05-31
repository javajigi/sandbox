import unittest
from slipp.game import BowlingGame

class BowlingGameTest(unittest.TestCase):
    def test_roll_gutter(self):
        game = BowlingGame()
        game.roll(8)
        self.assertEqual(game.get_total_score(), 8)
        game.roll(0) # gutter
        
        game.roll(7)
        self.assertEqual(game.get_total_score(), 15)
        
    def test_roll_spare(self):
        game = BowlingGame()
        game.roll(8)
        game.roll(2) # spare
        self.assertEqual(game.get_total_score(), 10)
        game.roll(5)
        self.assertEqual(game.get_total_score(), 20)
        game.roll(3) # gutter
        self.assertEqual(game.get_total_score(), 23)

    def test_roll_strike(self):
        game = BowlingGame()
        game.roll(10) #strike
        game.roll(8)
        game.roll(1)
        self.assertEqual(game.get_total_score(), 28)
    
    def test_roll_strike_strike(self):
        game = BowlingGame()
        game.roll(10) #strike
        self.assertEqual(game.get_total_score(), 10)
        game.roll(10)
        self.assertEqual(game.get_total_score(), 30)
        game.roll(8)
        self.assertEqual(game.get_total_score(), 54)
        game.roll(1)
        self.assertEqual(game.get_total_score(), 56)
    
    def test_roll_ten_frame(self):
        game = BowlingGame()
        for i in range(0, 12):
            game.roll(10)
        self.assertEqual(game.get_total_score(), 300)
    
        game = BowlingGame()
        for i in range(0, 11):
            game.roll(10)
        game.roll(8)
        self.assertEqual(game.get_total_score(), 298)
    
        game = BowlingGame()
        for i in range(0, 9):
            game.roll(10)
        game.roll(9)
        game.roll(1)
        game.roll(8)
        self.assertEqual(game.get_total_score(), 277)
    
        game = BowlingGame()
        for i in range(0, 11):
            game.roll(3)
        self.assertEqual(game.get_total_score(), 33)
    
    def test_full_game(self):
        game = BowlingGame()
        game.roll(9)
        game.roll(1) # 1frame
        game.roll(10) # 2frame
        self.assertEqual(game.get_total_score(), 30)    
        game.roll(7)
        game.roll(2) # 3frame
        self.assertEqual(game.get_total_score(), 48)
        game.roll(10) # 4frame
        game.roll(10) # 5frame
        game.roll(7)
        game.roll(3) # 6frame
        game.roll(9)
        game.roll(0) # 7frame
        self.assertEqual(game.get_total_score(), 123)
        game.roll(8)
        game.roll(2) # 8frame
        game.roll(10) # 9frame
        game.roll(8)
        game.roll(2)
        game.roll(7) # 10frame
        self.assertEqual(game.get_total_score(), 180)