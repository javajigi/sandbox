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

		for i in range(1, 11):
			if self.is_strike(frame_index):
				print "strike frame_index : %d" % frame_index
				total_score += 10 + self.get_bonus_strike_point(frame_index)
				frame_index += 1
			elif self.is_spare(frame_index):
				print "spare frame_index : %d" % frame_index
				total_score += 10 + self.get_bonus_spare_point(frame_index)
				frame_index += 2
			else:
				if self.is_ten_frame(i):
					total_score += self.rolls[frame_index] + self.rolls[frame_index+1]
				else:
					total_score += self.rolls[frame_index]
				frame_index += 1				
		return total_score

	def is_ten_frame(self, frame):
		return frame == 10


	def is_strike(self, frame_index):		
		return self.rolls[frame_index] == 10

	def get_bonus_strike_point(self, frame_index):
		return self.rolls[frame_index+1] + self.rolls[frame_index+2]

	def is_spare(self, frame_index):
		return self.rolls[frame_index] + self.rolls[frame_index+1] == 10

	def get_bonus_spare_point(self, frame_index):
		return self.rolls[frame_index+2]
