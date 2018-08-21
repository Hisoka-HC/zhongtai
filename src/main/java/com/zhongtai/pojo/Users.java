/*    */ package com.zhongtai.pojo;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Users
/*    */ {
/*    */   private Integer id;
/*    */   private String username;
/*    */   private String password;
/*    */   private String name;
/*    */   private String sex;
/*    */   private String phone;
           private Integer groupId;
           private Integer departmentId;
           private Integer roleId;
           private Role role;
/*    */   private Groups group;
/*    */   private Department department;
/*    */

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", groupId=" + groupId +
                ", departmentId=" + departmentId +
                ", roleId=" + roleId +
                ", role=" + role +
                ", group=" + group +
                ", department=" + department +
                '}';
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getGroupId() {
                return groupId;
            }

            public void setGroupId(Integer groupId) {
                this.groupId = groupId;
            }

            public Integer getDepartmentId() {
                return departmentId;
            }

            public void setDepartmentId(Integer departmentId) {
                this.departmentId = departmentId;
            }


/*    */   public Integer getId()
/*    */   {
/* 22 */     return this.id;
/*    */   }
/*    */   
/* 25 */   public void setId(Integer id) { this.id = id; }
/*    */   
/*    */   public String getUsername() {
/* 28 */     return this.username;
/*    */   }
/*    */   
/* 31 */   public void setUsername(String username) { this.username = username; }
/*    */   
/*    */   public String getPassword() {
/* 34 */     return this.password;
/*    */   }
/*    */   
/* 37 */   public void setPassword(String password) { this.password = password; }
/*    */   
/*    */   public String getName() {
/* 40 */     return this.name;
/*    */   }
/*    */   
/* 43 */   public void setName(String name) { this.name = name; }
/*    */   
/*    */   public String getSex() {
/* 46 */     return this.sex;
/*    */   }
/*    */   
/* 49 */   public void setSex(String sex) { this.sex = sex; }
/*    */   
/*    */   public String getPhone() {
/* 52 */     return this.phone;
/*    */   }
/*    */   
/* 55 */   public void setPhone(String phone) { this.phone = phone; }
/*    */   
/*    */   public Groups getGroup() {
/* 58 */     return this.group;
/*    */   }
/*    */   
/* 61 */   public void setGroup(Groups group) { this.group = group; }
/*    */   
/*    */   public Department getDepartment() {
/* 64 */     return this.department;
/*    */   }
/*    */   
/* 67 */   public void setDepartment(Department department) { this.department = department; }
/*    */   
/*    */   public Users(String username, String password, String name, String sex, String phone, Groups group, Department department)
/*    */   {
/* 77 */     this.username = username;
/* 78 */     this.password = password;
/* 79 */     this.name = name;
/* 80 */     this.sex = sex;
/* 81 */     this.phone = phone;
/* 82 */     this.group = group;
/* 83 */     this.department = department;
/*    */   }
/*    */   
/*    */   public Users() {}
/*    */ }


/* Location:              D:\shidaiwang\WEB-INF\classes\!\com\zhongtai\po\Users.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */