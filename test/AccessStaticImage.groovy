100.times {
	def startTime = System.currentTimeMillis()
	def file = new File("120810_PCroom_28291.jpg")
	def out = new BufferedOutputStream(new FileOutputStream(file))
	// out << new URL("http://static.archeage.com/images/game/img_ability_01.gif").openStream()
	//out << new URL("http://postfiles9.naver.net/20120322_264/hahawonsell_1332392875629FKOPW_JPEG/k-11.jpg?type=w2").openStream()
	out << new URL("http://postfiles4.naver.net/20120813_115/odoomi_1344809007825qGykY_JPEG/main.jpg?type=w1").openStream()
	out.close()
	file.delete()
	def endTime = System.currentTimeMillis()
	println("download time : " + (endTime-startTime))
}