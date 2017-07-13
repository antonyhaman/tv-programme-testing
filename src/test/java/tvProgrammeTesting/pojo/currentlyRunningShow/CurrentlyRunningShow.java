package tvProgrammeTesting.pojo.currentlyRunningShow;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.time.LocalDateTime;
import java.util.List;

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
        private int id;
        @SerializedName("external_id")
        private int externalId;
        @SerializedName("title")
        private String title;
        @SerializedName("programs")
        private List<CurrentlyRunningShow.Program> programs = null;

        public int getId() {
            return id;
        }

        public int getExternalId() {
            return externalId;
        }

        public String getTitle() {
            return title;
        }

        public List<Program> getPrograms() {
            return programs;
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
        private int id;
        @SerializedName("external_id")
        private int externalId;
        @SerializedName("title")
        private String title;

        public int getId() {
            return id;
        }

        public int getExternalId() {
            return externalId;
        }

        public String getTitle() {
            return title;
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
        private int externalId;
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
        private int startTimestamp;
        @SerializedName("end")
        private LocalDateTime end;
        @SerializedName("end_timestamp")
        private int endTimestamp;

        public int getExternalId() {
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

        public int getStartTimestamp() {
            return startTimestamp;
        }

        public LocalDateTime getEnd() {
            return end;
        }

        public int getEndTimestamp() {
            return endTimestamp;
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
        private int id;
        @SerializedName("external_id")
        private int externalId;
        @SerializedName("title")
        private String title;

        public int getId() {
            return id;
        }

        public int getExternalId() {
            return externalId;
        }

        public String getTitle() {
            return title;
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

        CurrentlyRunningShow example = (CurrentlyRunningShow) o;

        return new EqualsBuilder()
                .append(getResult(), example.getResult())
                .append(getData(), example.getData())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getResult())
                .append(getData())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "CurrentlyRunningShow{" +
                "result='" + result + '\'' +
                ", data=" + data +
                '}';
    }
}