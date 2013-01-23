package net.slipp.tag;

public class Tag {
    private String name;
    private int taggedCount;
    private boolean newed;

    public Tag(String name) {
        this(name, false);
    }
    
    private Tag(String name, boolean newed) {
        this.name = name;
        this.newed = newed;        
    }
    
    public String getName() {
        return name;
    }

    public int getTaggedCount() {
        return taggedCount;
    }

    public boolean isNewed() {
        return newed;
    }
    
    public static Tag createNewTag(String name) {
        return new Tag(name, true);
    }
    
    public void tagged() {
        taggedCount += 1;
    }
    
    public void deTagged() {
        taggedCount -= 1;
    }
}