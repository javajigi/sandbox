package net.slipp.qna;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {
    private List<Answer> answers;

    public List<Answer> getAnswers() {
        return answers;
    }

    public Answer getBestAnswer() {
        if (getAnswers() == null && getAnswers().isEmpty()) {
            return null;
        }

        List<Answer> sortAnswers = new ArrayList<Answer>();
        sortAnswers.addAll(getAnswers());
        Collections.sort(sortAnswers);

        Answer answer = sortAnswers.get(0);
        if ( answer.getSumLike() > 1 ) {
            return answer;
        }
        return null;
    }
}
