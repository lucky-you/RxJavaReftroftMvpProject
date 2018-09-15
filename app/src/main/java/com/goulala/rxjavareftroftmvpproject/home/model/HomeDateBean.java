package com.goulala.rxjavareftroftmvpproject.home.model;


import java.util.List;

/**
 * Created by: Z_B on 2018/9/4.
 * Function:
 */
public class HomeDateBean {


    private String stat;
    private List<DataBean> data;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * uniquekey : 9a1c384cf370c4eadff667a03784b652
         * title : 秦皇岛市委副书记田金昌拟任中国雄安集团党委书记、董事长
         * date : 2018-09-15 15:09
         * category : 头条
         * author_name : 澎湃新闻网
         * url : http://mini.eastday.com/mobile/180915150912362.html
         * thumbnail_pic_s : http://09imgmini.eastday.com/mobile/20180915/20180915150912_b586b806ba223a470222315ce3141e07_1_mwpm_03200403.jpg
         * thumbnail_pic_s02 : http://00imgmini.eastday.com/mobile/20180915/20180915150338_7605827c29795210cc4e5dc7f4812879_2_mwpm_03200403.jpg
         * thumbnail_pic_s03 : http://00imgmini.eastday.com/mobile/20180915/20180915150338_7605827c29795210cc4e5dc7f4812879_1_mwpm_03200403.jpg
         */

        private String uniquekey;
        private String title;
        private String date;
        private String category;
        private String author_name;
        private String url;
        private String thumbnail_pic_s;
        private String thumbnail_pic_s02;
        private String thumbnail_pic_s03;

        public String getUniquekey() {
            return uniquekey;
        }

        public void setUniquekey(String uniquekey) {
            this.uniquekey = uniquekey;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getAuthor_name() {
            return author_name;
        }

        public void setAuthor_name(String author_name) {
            this.author_name = author_name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getThumbnail_pic_s() {
            return thumbnail_pic_s;
        }

        public void setThumbnail_pic_s(String thumbnail_pic_s) {
            this.thumbnail_pic_s = thumbnail_pic_s;
        }

        public String getThumbnail_pic_s02() {
            return thumbnail_pic_s02;
        }

        public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
            this.thumbnail_pic_s02 = thumbnail_pic_s02;
        }

        public String getThumbnail_pic_s03() {
            return thumbnail_pic_s03;
        }

        public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
            this.thumbnail_pic_s03 = thumbnail_pic_s03;
        }
    }
}
