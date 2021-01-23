# JPAExamples
JPA Examples

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
