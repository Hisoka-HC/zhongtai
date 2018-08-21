/*    */ package com.zhongtai.pojo;
/*    */ 
/*    */ 
/*    */ public class Process
/*    */ {
/*    */   private Integer id;
/*    */   private String message;
            private String name;
            private String sex;
            private String phone;
/*    */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /*    */   public Integer getId()
/*    */   {
/* 11 */     return this.id;
/*    */   }
/*    */   
/* 14 */   public void setId(Integer id) { this.id = id; }
/*    */   
/*    */   public String getMessage() {
/* 17 */     return this.message;
/*    */   }
/*    */   
/* 20 */   public void setMessage(String message) { this.message = message; }
/*    */ }


/* Location:              D:\shidaiwang\WEB-INF\classes\!\com\zhongtai\po\Process.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */