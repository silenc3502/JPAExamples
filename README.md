# JPAExamples
JPA Examples

# Check Contents  
```
1. demo
2. lombok
3. mybatis
4. hibernate
5. jpa_basics
6. jps_basics2
7. jpa_basics3
8. many2one
9. many2one2
10. many2one_update
11. many2one_delete
12. one2many
13. one2many_cascade
14. one2one
15. many2many
16. 
```

# How to remove MYSQL
```make
sudo apt-get remove --purge mysql*
```

# How to check is it remove ?  
```make
dpkg -l | grep mysql
```

# Remove Config Info
```make
sudo apt-get remove --purge mysql-apt-config
```

# How to clearly remove mysql ?  
```make
sudo rm -rf /etc/mysql /var/lib/mysql
sudo apt-get autoremove
sudo apt-get autoclean
```

# Download *.deb file  
```make
wget http://repo.mysql.com/mysql-apt-config_0.8.15-1_all.deb
```

# Installing *.deb file
```make
sudo dpkg -i mysql-apt-config_0.8.15-1_all.deb
```

# How to Install MYSQL  
```make
sudo apt update
sudo apt-get install mysql-server
```

# Additional Config  
```make
sudo mysql_secure_installation
```

# Start MYSQL Service
```make
service mysql restart
```

# How to Login with root
```make
mysql -u root  -p
```

# How to check Character Set on MYSQL ?
```make
status
```

# How to make MYSQL user ?
```make
create user 'bitweb'@localhost identified by 'dkdlxl123';
```

# How to give Privileges ?
```make
grant all privileges on *.* to 'bitweb'@localhost;
```

# How to make Schema ?
```make
create database jpa_test;
```

