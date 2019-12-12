package lv.helloit.switter;

import java.time.LocalDateTime;
import java.util.Objects;

public class Swit {
    private Long id;
    private String content;
    private String author;
    private LocalDateTime publishDate;
    private LocalDateTime lastUpdateDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Swit swit = (Swit) o;
        return Objects.equals(id, swit.id) &&
                Objects.equals(content, swit.content) &&
                Objects.equals(author, swit.author) &&
                Objects.equals(publishDate, swit.publishDate) &&
                Objects.equals(lastUpdateDate, swit.lastUpdateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, author, publishDate, lastUpdateDate);
    }

    @Override
    public String toString() {
        return "Swit{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", publishDate=" + publishDate +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
