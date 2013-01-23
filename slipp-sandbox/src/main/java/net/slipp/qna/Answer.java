package net.slipp.qna;

public class Answer implements Comparable<Answer> {
    private Integer sumLike = 0;
    
    public Integer getSumLike() {
        return sumLike;
    }
    
    @Override
    public int compareTo(Answer o) {
        int t_ = this.sumLike.intValue();
        int o_ = o.getSumLike().intValue();
        return t_ < o_ ? 1 : (t_ > o_ ? -1 : 0);
    }
}
