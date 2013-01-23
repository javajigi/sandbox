package net.slipp.tag;

public interface QuestionRepository {
    Question findOne(Long id);
    
    Question save(Question question);
}
