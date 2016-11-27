package io.netopen.hotbitmapgg.frescodemo.entity;

import java.util.List;

/**
 * Created by hcc on 2016/11/27 11:55
 * 100332338@qq.com
 */

public class MeiziInfo
{

    /**
     * error : false
     * results : [{"_id":"58378c0f421aa91cade7a57d","createdAt":"2016-11-25T08:55:43.173Z","desc":"11-25","publishedAt":"2016-11-25T11:29:49.832Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034jw1fa42ktmjh4j20u011hn8g.jpg","used":true,"who":"dmj"},{"_id":"58362e82421aa9721eb68ac1","createdAt":"2016-11-24T08:04:18.98Z","desc":"11-24","publishedAt":"2016-11-24T11:40:53.615Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034jw1fa2vh33em9j20u00zmabz.jpg","used":true,"who":"daimajia "},{"_id":"58350b5e421aa972148296ed","createdAt":"2016-11-23T11:22:06.516Z","desc":"11-23","publishedAt":"2016-11-23T11:27:52.847Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034gw1fa1vkn6nerj20u011gdjm.jpg","used":true,"who":"代码家"},{"_id":"5833b7f1421aa926e26ae819","createdAt":"2016-11-22T11:13:53.663Z","desc":"11-22","publishedAt":"2016-11-22T11:30:13.971Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034gw1fa0ppsw0a7j20u00u0thp.jpg","used":true,"who":"daimajia"},{"_id":"58326224421aa929ac960b05","createdAt":"2016-11-21T10:55:32.265Z","desc":"11-21","publishedAt":"2016-11-21T11:16:48.599Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034gw1f9zjk8iaz2j20u011hgsc.jpg","used":true,"who":"代码家"},{"_id":"582e4c38421aa94ffa9f7641","createdAt":"2016-11-18T08:32:56.22Z","desc":"AB","publishedAt":"2016-11-18T11:21:35.425Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034jw1f9vyl2fqi0j20u011habc.jpg","used":true,"who":"daimajia "},{"_id":"582cf408421aa95002741a8f","createdAt":"2016-11-17T08:04:24.781Z","desc":"11-17","publishedAt":"2016-11-17T11:32:04.807Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034jw1f9us52puzsj20u00u0jtd.jpg","used":true,"who":"daimajia "},{"_id":"582ba25b421aa93a5939d4bc","createdAt":"2016-11-16T08:03:39.788Z","desc":"11-16","publishedAt":"2016-11-16T11:37:18.947Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034jw1f9tmhxq87lj20u011htae.jpg","used":true,"who":"daimajia"},{"_id":"582a56cb421aa9102c2ec6e7","createdAt":"2016-11-15T08:28:59.621Z","desc":"11-15","publishedAt":"2016-11-15T11:26:11.821Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034gw1f9shm1cajkj20u00jy408.jpg","used":true,"who":"daimajia"},{"_id":"58290634421aa911cf2e155c","createdAt":"2016-11-14T08:32:52.84Z","desc":"11-14","publishedAt":"2016-11-14T11:36:49.680Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034jw1f9rc3qcfm1j20u011hmyk.jpg","used":true,"who":"daimajia"}]
     */

    private boolean error;

    private List<ResultsBean> results;

    public boolean isError()
    {

        return error;
    }

    public void setError(boolean error)
    {

        this.error = error;
    }

    public List<ResultsBean> getResults()
    {

        return results;
    }

    public void setResults(List<ResultsBean> results)
    {

        this.results = results;
    }

    public static class ResultsBean
    {

        /**
         * _id : 58378c0f421aa91cade7a57d
         * createdAt : 2016-11-25T08:55:43.173Z
         * desc : 11-25
         * publishedAt : 2016-11-25T11:29:49.832Z
         * source : chrome
         * type : 福利
         * url : http://ww2.sinaimg.cn/large/610dc034jw1fa42ktmjh4j20u011hn8g.jpg
         * used : true
         * who : dmj
         */

        private String _id;

        private String createdAt;

        private String desc;

        private String publishedAt;

        private String source;

        private String type;

        private String url;

        private boolean used;

        private String who;

        public String get_id()
        {

            return _id;
        }

        public void set_id(String _id)
        {

            this._id = _id;
        }

        public String getCreatedAt()
        {

            return createdAt;
        }

        public void setCreatedAt(String createdAt)
        {

            this.createdAt = createdAt;
        }

        public String getDesc()
        {

            return desc;
        }

        public void setDesc(String desc)
        {

            this.desc = desc;
        }

        public String getPublishedAt()
        {

            return publishedAt;
        }

        public void setPublishedAt(String publishedAt)
        {

            this.publishedAt = publishedAt;
        }

        public String getSource()
        {

            return source;
        }

        public void setSource(String source)
        {

            this.source = source;
        }

        public String getType()
        {

            return type;
        }

        public void setType(String type)
        {

            this.type = type;
        }

        public String getUrl()
        {

            return url;
        }

        public void setUrl(String url)
        {

            this.url = url;
        }

        public boolean isUsed()
        {

            return used;
        }

        public void setUsed(boolean used)
        {

            this.used = used;
        }

        public String getWho()
        {

            return who;
        }

        public void setWho(String who)
        {

            this.who = who;
        }
    }
}
