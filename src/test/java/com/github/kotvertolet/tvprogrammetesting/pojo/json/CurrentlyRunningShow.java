package com.github.kotvertolet.tvprogrammetesting.pojo.json;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class CurrentlyRunningShow {

    @SerializedName("result")
    private String result;
    @SerializedName("data")
    private List<Data> data = null;

    public String getResult() {
        return result;
    }

    public List<Data> getData() {
        return data;
    }

    public class Data {

        @SerializedName("id")
        private Integer id;
        @SerializedName("external_id")
        private Integer externalId;
        @SerializedName("title")
        private String title;
        @SerializedName("programs")
        private List<CurrentlyRunningShow.Program> programs = null;

        public Integer getId() {
            return id;
        }

        public Integer getExternalId() {
            return externalId;
        }

        public String getTitle() {
            return title;
        }

        public List<Program> getPrograms() {
            return programs;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Data)) return false;
            Data data = (Data) o;
            return Objects.equals(getId(), data.getId()) &&
                    Objects.equals(getExternalId(), data.getExternalId()) &&
                    Objects.equals(getTitle(), data.getTitle()) &&
                    Objects.equals(getPrograms(), data.getPrograms());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getExternalId(), getTitle(), getPrograms());
        }

        @Override
        public String toString() {
            return "Data{" +
                    "id=" + id +
                    ", externalId=" + externalId +
                    ", title='" + title + '\'' +
                    ", programs=" + programs +
                    '}';
        }
    }

    public class Genre {

        @SerializedName("id")
        private Integer id;
        @SerializedName("external_id")
        private Integer externalId;
        @SerializedName("title")
        private String title;

        public Integer getId() {
            return id;
        }

        public Integer getExternalId() {
            return externalId;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Genre)) return false;
            Genre genre = (Genre) o;
            return Objects.equals(getId(), genre.getId()) &&
                    Objects.equals(getExternalId(), genre.getExternalId()) &&
                    Objects.equals(getTitle(), genre.getTitle());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getExternalId(), getTitle());
        }

        @Override
        public String toString() {
            return "Genre{" +
                    "id=" + id +
                    ", externalId=" + externalId +
                    ", title='" + title + '\'' +
                    '}';
        }
    }

    public class Program {

        @SerializedName("external_id")
        private Integer externalId;
        @SerializedName("object_id")
        private Object objectId;
        @SerializedName("year")
        private String year;
        @SerializedName("title")
        private String title;
        @SerializedName("description")
        private String description;
        @SerializedName("schedule_string")
        private Object scheduleString;
        @SerializedName("genre")
        private CurrentlyRunningShow.Genre genre;
        @SerializedName("category")
        private CurrentlyRunningShow.Category category;
        @SerializedName("virtual_object_id")
        private String virtualObjectId;
        @SerializedName("start")
        private LocalDateTime start;
        @SerializedName("start_timestamp")
        private Integer startTimestamp;
        @SerializedName("end")
        private LocalDateTime end;
        @SerializedName("end_timestamp")
        private Integer endTimestamp;

        public Integer getExternalId() {
            return externalId;
        }

        public Object getObjectId() {
            return objectId;
        }

        public String getYear() {
            return year;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public Object getScheduleString() {
            return scheduleString;
        }

        public Genre getGenre() {
            return genre;
        }

        public Category getCategory() {
            return category;
        }

        public String getVirtualObjectId() {
            return virtualObjectId;
        }

        public LocalDateTime getStart() {
            return start;
        }

        public Integer getStartTimestamp() {
            return startTimestamp;
        }

        public LocalDateTime getEnd() {
            return end;
        }

        public Integer getEndTimestamp() {
            return endTimestamp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Program)) return false;
            Program program = (Program) o;
            return Objects.equals(getExternalId(), program.getExternalId()) &&
                    Objects.equals(getObjectId(), program.getObjectId()) &&
                    Objects.equals(getYear(), program.getYear()) &&
                    Objects.equals(getTitle(), program.getTitle()) &&
                    Objects.equals(getDescription(), program.getDescription()) &&
                    Objects.equals(getScheduleString(), program.getScheduleString()) &&
                    Objects.equals(getGenre(), program.getGenre()) &&
                    Objects.equals(getCategory(), program.getCategory()) &&
                    Objects.equals(getVirtualObjectId(), program.getVirtualObjectId()) &&
                    Objects.equals(getStart(), program.getStart()) &&
                    Objects.equals(getStartTimestamp(), program.getStartTimestamp()) &&
                    Objects.equals(getEnd(), program.getEnd()) &&
                    Objects.equals(getEndTimestamp(), program.getEndTimestamp());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getExternalId(), getObjectId(), getYear(), getTitle(), getDescription(), getScheduleString(), getGenre(), getCategory(), getVirtualObjectId(), getStart(), getStartTimestamp(), getEnd(), getEndTimestamp());
        }

        @Override
        public String toString() {
            return "Program{" +
                    "externalId=" + externalId +
                    ", objectId=" + objectId +
                    ", year='" + year + '\'' +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", scheduleString=" + scheduleString +
                    ", genre=" + genre +
                    ", category=" + category +
                    ", virtualObjectId='" + virtualObjectId + '\'' +
                    ", start=" + start +
                    ", startTimestamp=" + startTimestamp +
                    ", end=" + end +
                    ", endTimestamp=" + endTimestamp +
                    '}';
        }
    }

    public class Category {

        @SerializedName("id")
        private Integer id;
        @SerializedName("external_id")
        private Integer externalId;
        @SerializedName("title")
        private String title;

        public Integer getId() {
            return id;
        }

        public Integer getExternalId() {
            return externalId;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Category)) return false;
            Category category = (Category) o;
            return Objects.equals(getId(), category.getId()) &&
                    Objects.equals(getExternalId(), category.getExternalId()) &&
                    Objects.equals(getTitle(), category.getTitle());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getExternalId(), getTitle());
        }

        @Override
        public String toString() {
            return "Category{" +
                    "id=" + id +
                    ", externalId=" + externalId +
                    ", title='" + title + '\'' +
                    '}';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CurrentlyRunningShow)) return false;
        CurrentlyRunningShow that = (CurrentlyRunningShow) o;
        return Objects.equals(getResult(), that.getResult()) &&
                Objects.equals(getData(), that.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResult(), getData());
    }

    @Override
    public String toString() {
        return "CurrentlyRunningShow{" +
                "result='" + result + '\'' +
                ", data=" + data +
                '}';
    }
}