class BowlingGame(object):
	def __init__(self):
		self.rolls = [0] * 21
		self.current_rolls = 0
	
	def roll(self, throw_down_pin):
		self.rolls[self.current_rolls] = throw_down_pin
		self.current_rolls += 1
	
	def get_total_score(self):
		total_score = 0
		frame_index = 0

		for i in range(1, 11):
			print ("frame no : %d" %i)
			if self.is_strike(frame_index):				
				total_score += 10 + self.get_bonus_strike_point(frame_index)
				frame_index += 1
				print ("strike frame_index : %d" %frame_index)
			elif self.is_spare(frame_index):				
				total_score += 10 + self.get_bonus_spare_point(frame_index)
				frame_index += 2
				print ("spare frame_index : %d" %frame_index)
			else:
				total_score += self.rolls[frame_index] + self.rolls[frame_index+1]
				frame_index += 2
				print ("gutter frame_index : %d" %frame_index)						
		return total_score

	def is_strike(self, frame_index):		
		return self.rolls[frame_index] == 10

	def get_bonus_strike_point(self, frame_index):
		return self.rolls[frame_index+1] + self.rolls[frame_index+2]

	def is_spare(self, frame_index):
		return self.rolls[frame_index] + self.rolls[frame_index+1] == 10

	def get_bonus_spare_point(self, frame_index):
		return self.rolls[frame_index+2]
