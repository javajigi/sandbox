class BowlingGame(object):
	def __init__(self):
		self.rolls = [0] * 21
		self.current_rolls = 0
	
	def roll(self, throw_down_pin):
		self.rolls[self.current_rolls] = throw_down_pin
		self.current_rolls += 1
	
	def get_total_score(self):
		print self.rolls
		total_score = 0
		frame_index = 0
		for pin in self.rolls:
			print "pin : %d" % pin
			if self.rolls[frame_index] + self.rolls[frame_index+1] == 10:
				total_score += 10 + self.rolls[frame_index+2]
				frame_index += 2
			else:
				total_score += pin
				frame_index += 1
		return total_score
	
	