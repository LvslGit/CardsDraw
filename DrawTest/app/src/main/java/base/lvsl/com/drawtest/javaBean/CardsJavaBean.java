package base.lvsl.com.drawtest.javaBean;

import java.util.List;

public class CardsJavaBean {
    /**
     * status : 1
     * msg : 查询成功
     * result : {"id":"4","title":"翻牌","listpic":"/uploads/file1/20180409/5acb1f92680ab.jpg","headpic":"/uploads/file1/20180404/5ac4247165a3e.png","begintime":"1522726620","endtime":"1525059420","addtime":"1523261338","description":"666","freetimes":"3","charge":"1.00","sort":"5","status":"1","adtitle":"666","adpic":"/uploads/img1/20180403/5ac31f197add2.jpg","home":"0","style":"3","headpic1x1":"http://118.178.228.52/uploads/file1/20180404/5ac4247165a3e.png","luckdraw_product":[{"id":"9","luckid":"4","name":"谢谢参与","pic1":"/uploads/img1/20180130/5a6fe1bbbf7a6.png","pic2":"/uploads/img1/20180130/5a6fe1cce2dbd.png","isad":"0","type":"6","url":"","deadline":"1517241600","state":"0","percent":"0.20000","num":"101","win_num":"13","greatnum":"0","productprice":"0.00","pic11x1":"http://118.178.228.52/uploads/img1/20180130/5a6fe1bbbf7a6.png"},{"id":"39","luckid":"4","name":"金主包","pic1":"","pic2":"/uploads/img1/20180404/5ac4248ae92c5.png","isad":"1","type":"1","url":"","deadline":"1525363200","state":"0","percent":"0.50000","num":"101","win_num":"23","greatnum":"0","productprice":"0.00","pic11x1":"http://118.178.228.52/uploads/img1/20180403/5ac31f197add2.jpg"},{"id":"26","luckid":"4","name":"原宝","pic1":"/uploads/img1/20180326/5ab84e9b61632.jpg","pic2":"/uploads/img1/20180326/5ab84e9d089df.jpg","isad":"0","type":"3","url":"","deadline":"1524672000","state":"0","percent":"0.30000","num":"101","win_num":"18","greatnum":"0","productprice":"0.10","pic11x1":"http://118.178.228.52/uploads/img1/20180326/5ab84e9b61632.jpg"}]}
     */

    private int status;
    private String msg;
    private ResultBean result;

    public CardsJavaBean() {
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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "CardsJavaBean{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }

    public static class ResultBean {
        /**
         * id : 4
         * title : 翻牌
         * listpic : /uploads/file1/20180409/5acb1f92680ab.jpg
         * headpic : /uploads/file1/20180404/5ac4247165a3e.png
         * begintime : 1522726620
         * endtime : 1525059420
         * addtime : 1523261338
         * description : 666
         * freetimes : 3
         * charge : 1.00
         * sort : 5
         * status : 1
         * adtitle : 666
         * adpic : /uploads/img1/20180403/5ac31f197add2.jpg
         * home : 0
         * style : 3
         * headpic1x1 : http://118.178.228.52/uploads/file1/20180404/5ac4247165a3e.png
         * luckdraw_product : [{"id":"9","luckid":"4","name":"谢谢参与","pic1":"/uploads/img1/20180130/5a6fe1bbbf7a6.png","pic2":"/uploads/img1/20180130/5a6fe1cce2dbd.png","isad":"0","type":"6","url":"","deadline":"1517241600","state":"0","percent":"0.20000","num":"101","win_num":"13","greatnum":"0","productprice":"0.00","pic11x1":"http://118.178.228.52/uploads/img1/20180130/5a6fe1bbbf7a6.png"},{"id":"39","luckid":"4","name":"金主包","pic1":"","pic2":"/uploads/img1/20180404/5ac4248ae92c5.png","isad":"1","type":"1","url":"","deadline":"1525363200","state":"0","percent":"0.50000","num":"101","win_num":"23","greatnum":"0","productprice":"0.00","pic11x1":"http://118.178.228.52/uploads/img1/20180403/5ac31f197add2.jpg"},{"id":"26","luckid":"4","name":"原宝","pic1":"/uploads/img1/20180326/5ab84e9b61632.jpg","pic2":"/uploads/img1/20180326/5ab84e9d089df.jpg","isad":"0","type":"3","url":"","deadline":"1524672000","state":"0","percent":"0.30000","num":"101","win_num":"18","greatnum":"0","productprice":"0.10","pic11x1":"http://118.178.228.52/uploads/img1/20180326/5ab84e9b61632.jpg"}]
         */

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
        private String style;
        private String headpic1x1;
        private List<LuckdrawProductBean> luckdraw_product;

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

        public String getStyle() {
            return style;
        }

        public void setStyle(String style) {
            this.style = style;
        }

        public String getHeadpic1x1() {
            return headpic1x1;
        }

        public void setHeadpic1x1(String headpic1x1) {
            this.headpic1x1 = headpic1x1;
        }

        public List<LuckdrawProductBean> getLuckdraw_product() {
            return luckdraw_product;
        }

        public void setLuckdraw_product(List<LuckdrawProductBean> luckdraw_product) {
            this.luckdraw_product = luckdraw_product;
        }

        public static class LuckdrawProductBean {
            /**
             * id : 9
             * luckid : 4
             * name : 谢谢参与
             * pic1 : /uploads/img1/20180130/5a6fe1bbbf7a6.png
             * pic2 : /uploads/img1/20180130/5a6fe1cce2dbd.png
             * isad : 0
             * type : 6
             * url :
             * deadline : 1517241600
             * state : 0
             * percent : 0.20000
             * num : 101
             * win_num : 13
             * greatnum : 0
             * productprice : 0.00
             * pic11x1 : http://118.178.228.52/uploads/img1/20180130/5a6fe1bbbf7a6.png
             */

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
            private String win_num;
            private String greatnum;
            private String productprice;
            private String pic11x1;

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

            public String getWin_num() {
                return win_num;
            }

            public void setWin_num(String win_num) {
                this.win_num = win_num;
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
        }
    }
}
