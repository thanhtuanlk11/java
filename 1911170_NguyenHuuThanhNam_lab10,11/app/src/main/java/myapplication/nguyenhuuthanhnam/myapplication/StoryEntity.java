package myapplication.nguyenhuuthanhnam.myapplication;

public class StoryEntity {
    private final String topicName;
    private final String name;
    private final String content;
    public StoryEntity(String topicName, String name, String content) {
        this.topicName = topicName;
        this.name = name;
        this.content = content;
    }
    public String getTopicName() {
        return topicName;
    }
    public String getName() {
        return name;
    }
    public String getContent() {
        return content;
    }
}