package base.lvsl.com.drawtest.javaBean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;

public class PrizeDetailJavaBean {

    private int    status;
    private String msg;
    private Result result;

    public PrizeDetailJavaBean() {
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
        return "PrizeDetailJavaBean{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }

    public class Result {

        private String id;
        private String title;
        private String listpic;
        private String headpic;
        private String begintime;
        private String endtime;
        private String addtime;
        private String description;
        private String freetimes;
        private String charge;
        private String sort;
        private String status;
        private String adtitle;
        private String adpic;
        private String home;
        private String headpic1x1;  // 背景图

        @JSONField(name = "luckdraw_product")
        private ArrayList<LuckdrawProduct> luckdrawProduct;

        public Result() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getListpic() {
            return listpic;
        }

        public void setListpic(String listpic) {
            this.listpic = listpic;
        }

        public String getHeadpic() {
            return headpic;
        }

        public void setHeadpic(String headpic) {
            this.headpic = headpic;
        }

        public String getBegintime() {
            return begintime;
        }

        public void setBegintime(String begintime) {
            this.begintime = begintime;
        }

        public String getEndtime() {
            return endtime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getFreetimes() {
            return freetimes;
        }

        public void setFreetimes(String freetimes) {
            this.freetimes = freetimes;
        }

        public String getCharge() {
            return charge;
        }

        public void setCharge(String charge) {
            this.charge = charge;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getAdtitle() {
            return adtitle;
        }

        public void setAdtitle(String adtitle) {
            this.adtitle = adtitle;
        }

        public String getAdpic() {
            return adpic;
        }

        public void setAdpic(String adpic) {
            this.adpic = adpic;
        }

        public String getHome() {
            return home;
        }

        public void setHome(String home) {
            this.home = home;
        }

        public String getHeadpic1x1() {
            return headpic1x1;
        }

        public void setHeadpic1x1(String headpic1x1) {
            this.headpic1x1 = headpic1x1;
        }

        public ArrayList<LuckdrawProduct> getLuckdrawProduct() {
            return luckdrawProduct;
        }

        public void setLuckdrawProduct(ArrayList<LuckdrawProduct> luckdrawProduct) {
            this.luckdrawProduct = luckdrawProduct;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", listpic='" + listpic + '\'' +
                    ", headpic='" + headpic + '\'' +
                    ", begintime='" + begintime + '\'' +
                    ", endtime='" + endtime + '\'' +
                    ", addtime='" + addtime + '\'' +
                    ", description='" + description + '\'' +
                    ", freetimes='" + freetimes + '\'' +
                    ", charge='" + charge + '\'' +
                    ", sort='" + sort + '\'' +
                    ", status='" + status + '\'' +
                    ", adtitle='" + adtitle + '\'' +
                    ", adpic='" + adpic + '\'' +
                    ", home='" + home + '\'' +
                    ", headpic1x1='" + headpic1x1 + '\'' +
                    ", luckdrawProduct=" + luckdrawProduct +
                    '}';
        }

        public class LuckdrawProduct {

            private String id;
            private String luckid;
            private String name;
            private String pic1;
            private String pic2;
            private String isad;
            private String type;
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

            public LuckdrawProduct() {
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

            public String getType() {
                return type;
            }

            public void setType(String type) {
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

            @Override
            public String toString() {
                return "LuckdrawProduct{" +
                        "id='" + id + '\'' +
                        ", luckid='" + luckid + '\'' +
                        ", name='" + name + '\'' +
                        ", pic1='" + pic1 + '\'' +
                        ", pic2='" + pic2 + '\'' +
                        ", isad='" + isad + '\'' +
                        ", type='" + type + '\'' +
                        ", url='" + url + '\'' +
                        ", deadline='" + deadline + '\'' +
                        ", state='" + state + '\'' +
                        ", percent='" + percent + '\'' +
                        ", num='" + num + '\'' +
                        ", winNum='" + winNum + '\'' +
                        ", greatnum='" + greatnum + '\'' +
                        ", productprice='" + productprice + '\'' +
                        ", pic11x1='" + pic11x1 + '\'' +
                        '}';
            }
        }
    }
}
