package com.work;

/**
 * 定义一个联系人的类
 * 用于存储联系人全部信息，id 姓名 性别 年龄 电话 邮件 地址
 * @author Administrator
 *
 */

    public class Contact {
        private String id;
        private String name;

        private String phone;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		@Override
		public String toString() {
			return "Contact [id=" + id + ", name=" + name + ", phone=" + phone
					+ "]";
		}
        
    }