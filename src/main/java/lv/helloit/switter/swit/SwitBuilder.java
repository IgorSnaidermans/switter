package lv.helloit.switter.swit;

import java.time.LocalDateTime;

public final class SwitBuilder {
    private Long id;
    private String content;
    private String author;
    private LocalDateTime publishDate;
    private LocalDateTime lastUpdateDate;

    private SwitBuilder() {
    }

    public static SwitBuilder aSwit() {
        return new SwitBuilder();
    }

    public SwitBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public SwitBuilder withContent(String content) {
        this.content = content;
        return this;
    }

    public SwitBuilder withAuthor(String author) {
        this.author = author;
        return this;
    }

    public SwitBuilder withPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
        return this;
    }

    public SwitBuilder withLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
        return this;
    }

    public Swit build() {
        Swit swit = new Swit();
        swit.setId(id);
        swit.setContent(content);
        swit.setAuthor(author);
        swit.setPublishDate(publishDate);
        swit.setLastUpdateDate(lastUpdateDate);
        return swit;
    }
}
