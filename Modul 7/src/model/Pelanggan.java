package model;

public class Pelanggan {
		private String nama;
		private String email;
		private String telepon;
		
		public Pelanggan(String nama, String email, String telepon) {
			this.nama = nama;	
			this.email = email;
			this.telepon = telepon;
		}
		
		
		public String getNama() {
			return this.nama;
		}
		
		public String getEmail() {
			return this.email;
		}
		
		public String getTelepon() {
			return this.telepon;
		}
		
		public void setNama(String nama) {
			this.nama = nama;
		}
		
		public void setEmail(String email) {
	        this.email = email;
	    }
		
		public void setTelepon(String telepon) {
	        this.telepon = telepon;
	    }
	}