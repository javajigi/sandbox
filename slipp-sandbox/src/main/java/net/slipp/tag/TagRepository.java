package net.slipp.tag;

public interface TagRepository {
    Tag findByName(String name);

    Tag save(Tag tag);
}