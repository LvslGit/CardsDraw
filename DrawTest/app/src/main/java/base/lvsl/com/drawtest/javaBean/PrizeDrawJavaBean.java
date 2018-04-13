package base.lvsl.com.drawtest.javaBean;

import com.alibaba.fastjson.annotation.JSONField;

public class PrizeDrawJavaBean {


    private int    status;
    private String msg;
    private Result result;

    public PrizeDrawJavaBean() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "PrizeDrawJavaBean{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }

    public class Result {

        private String id;
        private String luckid;
        private String name;
        private String pic1;
        private String pic2;
        private String isad;
        private int    type;
        private String url;
        private String deadline;
        private String state;
        private String percent;
        private String num;
        @JSONField(name = "win_num")
        private String winNum;
        private String greatnum;
        private String productprice;
        private String pic11x1;
        private String pic21x1;
        private String title1;
        private String title2;

        private Cardlist cardlist;  // 卡密信息

        public Result() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLuckid() {
            return luckid;
        }

        public void setLuckid(String luckid) {
            this.luckid = luckid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPic1() {
            return pic1;
        }

        public void setPic1(String pic1) {
            this.pic1 = pic1;
        }

        public String getPic2() {
            return pic2;
        }

        public void setPic2(String pic2) {
            this.pic2 = pic2;
        }

        public String getIsad() {
            return isad;
        }

        public void setIsad(String isad) {
            this.isad = isad;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getDeadline() {
            return deadline;
        }

        public void setDeadline(String deadline) {
            this.deadline = deadline;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getPercent() {
            return percent;
        }

        public void setPercent(String percent) {
            this.percent = percent;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getWinNum() {
            return winNum;
        }

        public void setWinNum(String winNum) {
            this.winNum = winNum;
        }

        public String getGreatnum() {
            return greatnum;
        }

        public void setGreatnum(String greatnum) {
            this.greatnum = greatnum;
        }

        public String getProductprice() {
            return productprice;
        }

        public void setProductprice(String productprice) {
            this.productprice = productprice;
        }

        public String getPic11x1() {
            return pic11x1;
        }

        public void setPic11x1(String pic11x1) {
            this.pic11x1 = pic11x1;
        }

        public String getPic21x1() {
            return pic21x1;
        }

        public void setPic21x1(String pic21x1) {
            this.pic21x1 = pic21x1;
        }

        public String getTitle1() {
            return title1;
        }

        public void setTitle1(String title1) {
            this.title1 = title1;
        }

        public String getTitle2() {
            return title2;
        }

        public void setTitle2(String title2) {
            this.title2 = title2;
        }

        public Cardlist getCardlist() {
            return cardlist;
        }

        public void setCardlist(Cardlist cardlist) {
            this.cardlist = cardlist;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "id='" + id + '\'' +
                    ", luckid='" + luckid + '\'' +
                    ", name='" + name + '\'' +
                    ", pic1='" + pic1 + '\'' +
                    ", pic2='" + pic2 + '\'' +
                    ", isad='" + isad + '\'' +
                    ", type=" + type +
                    ", url='" + url + '\'' +
                    ", deadline='" + deadline + '\'' +
                    ", state='" + state + '\'' +
                    ", percent='" + percent + '\'' +
                    ", num='" + num + '\'' +
                    ", winNum='" + winNum + '\'' +
                    ", greatnum='" + greatnum + '\'' +
                    ", productprice='" + productprice + '\'' +
                    ", pic11x1='" + pic11x1 + '\'' +
                    ", pic21x1='" + pic21x1 + '\'' +
                    ", title1='" + title1 + '\'' +
                    ", title2='" + title2 + '\'' +
                    ", cardlist=" + cardlist +
                    '}';
        }

        public class Cardlist {
            private String id;
            private String couponid;
            private String exid;
            @JSONField(name = "luck_pid")
            private String luckPid;
            private String cardkey;
            private String cardvalue;
            private String uid;
            private long gettime;
            private String state;
            private String type;

            public Cardlist() {
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCouponid() {
                return couponid;
            }

            public void setCouponid(String couponid) {
                this.couponid = couponid;
            }

            public String getExid() {
                return exid;
            }

            public void setExid(String exid) {
                this.exid = exid;
            }

            public String getLuckPid() {
                return luckPid;
            }

            public void setLuckPid(String luckPid) {
                this.luckPid = luckPid;
            }

            public String getCardkey() {
                return cardkey;
            }

            public void setCardkey(String cardkey) {
                this.cardkey = cardkey;
            }

            public String getCardvalue() {
                return cardvalue;
            }

            public void setCardvalue(String cardvalue) {
                this.cardvalue = cardvalue;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public long getGettime() {
                return gettime;
            }

            public void setGettime(long gettime) {
                this.gettime = gettime;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            @Override
            public String toString() {
                return "Cardlist{" +
                        "id='" + id + '\'' +
                        ", couponid='" + couponid + '\'' +
                        ", exid='" + exid + '\'' +
                        ", luckPid='" + luckPid + '\'' +
                        ", cardkey='" + cardkey + '\'' +
                        ", cardvalue='" + cardvalue + '\'' +
                        ", uid='" + uid + '\'' +
                        ", gettime='" + gettime + '\'' +
                        ", state='" + state + '\'' +
                        ", type='" + type + '\'' +
                        '}';
            }
        }
    }
}
