package lv.helloit.switter.swit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name="swit") //имя таблицы
public class Swit {
    @Id
    private String id;
    @Column
    private String content;
    @Column
    private String userId;
    @Column
    private LocalDateTime publishDate;
    @Column
    private LocalDateTime lastUpdateDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Swit swit = (Swit) o;
        return Objects.equals(id, swit.id) &&
                Objects.equals(content, swit.content) &&
                Objects.equals(userId, swit.userId) &&
                Objects.equals(publishDate, swit.publishDate) &&
                Objects.equals(lastUpdateDate, swit.lastUpdateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, userId, publishDate, lastUpdateDate);
    }

    @Override
    public String toString() {
        return "Swit{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", userId='" + userId + '\'' +
                ", publishDate=" + publishDate +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
