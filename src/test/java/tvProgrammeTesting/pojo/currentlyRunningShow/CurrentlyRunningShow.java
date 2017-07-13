package tvProgrammeTesting.pojo.currentlyRunningShow;

import com.google.gson.annotations.SerializedName;

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
        public String toString() {
            return "Category{" +
                    "id=" + id +
                    ", externalId=" + externalId +
                    ", title='" + title + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CurrentlyRunningShow{" +
                "result='" + result + '\'' +
                ", data=" + data +
                '}';
    }
}