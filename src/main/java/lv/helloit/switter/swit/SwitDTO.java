package lv.helloit.switter.swit;

import java.time.LocalDateTime;
import java.util.Objects;

public class SwitDTO {
    private String userEmail;
    private String id;
    private String content;
    private String userId;
    private String publishDate;
    private String lastUpdateDate;

    private SwitDTO(Builder builder) {
        setUserEmail(builder.userEmail);
        setId(builder.id);
        setContent(builder.content);
        setUserId(builder.userId);
        setPublishDate(builder.publishDate);
        setLastUpdateDate(builder.lastUpdateDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SwitDTO switDTO = (SwitDTO) o;
        return Objects.equals(userEmail, switDTO.userEmail) &&
                Objects.equals(id, switDTO.id) &&
                Objects.equals(content, switDTO.content) &&
                Objects.equals(userId, switDTO.userId) &&
                Objects.equals(publishDate, switDTO.publishDate) &&
                Objects.equals(lastUpdateDate, switDTO.lastUpdateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEmail, id, content, userId, publishDate, lastUpdateDate);
    }

    @Override
    public String toString() {
        return "SwitDTO{" +
                "userEmail='" + userEmail + '\'' +
                ", id=" + id +
                ", content='" + content + '\'' +
                ", userId='" + userId + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", lastUpdateDate='" + lastUpdateDate + '\'' +
                '}';
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public static final class Builder {
        private String userEmail;
        private String id;
        private String content;
        private String userId;
        private String publishDate;
        private String lastUpdateDate;

        public Builder() {
        }

        public Builder userEmail(String val) {
            userEmail = val;
            return this;
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder content(String val) {
            content = val;
            return this;
        }

        public Builder userId(String val) {
            userId = val;
            return this;
        }

        public Builder publishDate(String val) {
            publishDate = val;
            return this;
        }

        public Builder lastUpdateDate(String val) {
            lastUpdateDate = val;
            return this;
        }

        public SwitDTO build() {
            return new SwitDTO(this);
        }
    }
}
