package net.slipp.tag;

import java.util.Set;

public class QuestionService {
    private QuestionRepository questionRepository;
    
    public void create(String title, String contents, Set<Tag> tags) {
        Question question = new Question(tags);
        questionRepository.save(question);
    }
    
    public void update(Long id, String title, String contents, Set<Tag> tags) {
        Question question = questionRepository.findOne(id);
        question.update(tags);
        questionRepository.save(question);
    }
}
