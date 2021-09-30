package wenchao.jjy.core.info;

import java.io.Serializable;
import java.util.Objects;

public class Entry implements Serializable {

    private Integer model;

    private String hash;

    private Integer stage;

    private String path;

    public Entry(EntryBuilder builder) {
        this.model = builder.model;
        this.hash = builder.hash;
        this.stage = builder.stage;
        this.path = builder.path;
    }

    public Integer getModel() {
        return model;
    }

    public String getHash() {
        return hash;
    }

    public Integer getStage() {
        return stage;
    }

    public String getPath() {
        return path;
    }

    public static EntryBuilder builder() {
        return new EntryBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return Objects.equals(hash, entry.hash) &&
                Objects.equals(path, entry.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hash, path);
    }

    public static class EntryBuilder {
        private Integer model = 100644;

        private String hash;

        private Integer stage;

        private String path;

        public EntryBuilder model(Integer model) {
            this.model = model;
            return this;
        }

        public EntryBuilder hash(String hash) {
            this.hash = hash;
            return this;
        }

        public EntryBuilder stage(Integer stage) {
            this.stage = stage;
            return this;
        }

        public EntryBuilder path(String path) {
            this.path = path;
            return this;
        }

        public Entry build() {
            return new Entry(this);
        }
    }
}
