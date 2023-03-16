# 🎯 Jenkins ?

 <img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins1.png">

* Jenkins, Sürekli Entegrasyon (CI / Continuous Integration) ve Sürekli Dağıtım (CD / Continuous Delivery) amacıyla Java
  ile yazılmış açık kaynaklı bir otomasyon aracıdır.
* Jenkins, yazılım projelerinizi sürekli olarak oluşturmak ve test etmek için kullanılır, bu da geliştiricilerin
  değişiklikleri projeye entegre etmesini ve kullanıcıların yeni bir sürüm elde etmesini kolaylaştırır.
* Ayrıca, çok sayıda test ve dağıtım teknolojisiyle bütünleşerek yazılımınızı sürekli olarak teslim etmenize olanak
  tanır.
* Jenkins ile kuruluşlar, otomasyon yoluyla yazılım geliştirme sürecini hızlandırabilir.
* Jenkins, derleme, belgeleme, test etme, paketleme, aşama, devreye alma, statik analiz ve çok daha fazlası dahil olmak
  üzere her türlü geliştirme yaşam döngüsü sürecini entegre eder.

## 📌 Continuous Integration ?

* Yazılım geliştirme sürecinde birleştirme işlemlerinin otomatikleştirilmesidir.
* Yani, yazılım geliştiricilerin yaptıkları değişiklikler sürekli olarak ana kod tabanına entegre edilir ve böylece
  çatallanma ve birleştirme hataları önceden tespit edilir.
* Jenkins, bu süreci otomatikleştirmek için kullanılan bir araçtır.

## 📌 Continuous Delivery ?

* Yazılımın sürekli olarak hızlı ve güvenli bir şekilde kullanıma sunulması için yapılan bir dizi uygulama ve
  süreçlerdir.
* Bu süreçler arasında test otomasyonu, konfigürasyon yönetimi, uygulama dağıtımı, sürüm kontrolü vb. yer alır.
* Jenkins, bu süreci de otomatikleştirmek için kullanılan bir araçtır.

* Yani, CI, kod değişikliklerinin entegrasyonunu otomatikleştirirken, CD ise yazılımın sürekli olarak güvenli ve hızlı
  bir şekilde kullanıma sunulmasını sağlar.

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins2.png">

## 📌 Pipeline ?

* İşlerin ardışık bir sırada yapılması, bir işlemin çıktısının sonraki gelen işlemin girdisi olması anlamına
  gelmektedir.
* Fabrikadaki üretim bantlarını aklımıza getirelim.
* Üretilen eşya, hattın içerisinde farklı duraklara gelir.
* Her durakta bir işlem görür ve sonraki aşamaya geçer.

## 📌 Stage ?

* Pipeline içerisinde yer alan fazları ifade eder. Örneğin standart bir yazılım projesinde build -> test -> deploy
  adımlarından her birisi bir fazı ifade eder.

## 📌 Step ?

* Stage içerisinde yer alan adımları ifade eder.


* Jenkins üzerinde kodumuzun geçtiği aşamaları düşünelim:


* Build -> Test -> Deployment


* Build (derleme) aşamasını bir evre (stage) olarak düşünelim.
* Test evresi de sonraki evre.
* Deployment evresi de en son çalışacak evre olarak düşünelim.
* Bu işlemler Jenkins üzerinde ardışık bir sırada çalışmaktadır.
* Build işlemi hatalı olursa, yani kodumuz derlenmez ise, sonraki evreye geçmeyecektir.
* Aynı şekilde test safhasında hata oluşursa, deployment işlemi gerçekleşmeyecektir.

---

* Jenkins'i kısa bir özet geçtiğimize göre , jenkins nasıl kurulur o adımlara geçelim.

---

# 🎯 Jenkins Kurulumu ?

* İsterseniz kendi local'ınıza jenkinsi indirebilirsiniz.
* Ama ben böyle yapmayacağım.
* Google cloud hesabımdan ubuntu bir makine kuracağım.

## 📌 Google Cloud

* İlk önce https://cloud.google.com/ sayfasına girininiz.
* Compute Engine > VM instances > Create Instance diyerek oluşturmaya başlayalım.

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins3.png">

* Karşımıza böyle bir sayfa geliyor.
* Sunucu adınızı giriniz.

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins4.png">

* Boot Disk bölümünden ubuntu 20.04'ü seçiniz.

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins5.png">

* Son olarak HTTP isteklerine izin veriyoruz.
* Create kısmına tıklıyoruz.

---

* Sunucu oluşturma tamamlandı. Şimdi yapmamız gereken SSH ile içine giriyoruz.

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins6.png">

---

## 📌 SSH AND DOCKER

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins7.png">

* Karşımıza böyle bir ekran açılıyor.
* Şimdi yapmamız gereken sunucunun içinde docker ve docker-compose yüklemek.
* Yazacağım komutları tek tek yazınız.

---

* Docker

```shell
sudo apt-get remove docker docker-engine docker.io containerd runc
```

```shell
sudo apt update
```

```shell
sudo apt install apt-transport-https ca-certificates curl software-properties-common -y
```

```shell
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
```

```shell
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu focal stable"
```

```shell
apt-cache policy docker-ce
```

```shell
sudo apt install docker-ce -y
```

```shell
sudo systemctl status docker
```

```shell
docker --version
```

---

---

* Docker Compose

```shell
sudo curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
```

```shell
sudo chmod +x /usr/local/bin/docker-compose
```

```shell
docker-compose --version
```

---

* Eğer bu komutların ne işe yaradığını merak ediyorsanız bu sayfalara bakabilirsiniz :
* https://phoenixnap.com/kb/install-docker-on-ubuntu-20-04
* https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-compose-on-ubuntu-20-04

---

* Şimdi docker-compose.yaml dosyası oluşturup içine jenkins image'nı yazmamız gerekiyor.

```shell
sudo su 
```

```shell
nano docker-compose.yaml
```

* nano docker-compose.yaml dediğimiz zaman içine yazı yazabileceğimiz bir text sayfası açılır.

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins8.png">

* İçine jenkins image'nı yazıyoruz.
* Yazdıktan sonra ctrl + x , y , enter yapıyoruz.

```shell
ls
```

* ls çekip dosyamızı görebiliriz.

```yaml
version: "3.7"
services:

  jenkins:
    image: jenkins/jenkins:lts
    privileged: true
    restart: always
    user: root
    ports:
      - "8080:8080"
    container_name: jenkins
    volumes:
      - /var/run/docker.sock:/var/run/docker.sock
      - /usr/bin/docker:/usr/bin/docker
      - /usr/local/bin/docker-compose:/usr/local/bin/docker-compose
      - jenkins_vol:/var/lib/jenkins/data

volumes:
  jenkins_vol:
```

* Şimdi gelelim container ayağa kaldırma kısmına.

```shell
docker-compose up -d
```

```shell
docker ps 
```

* ps çekerek container durumuna bakabiliriz.

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins9.png">

* Artık jenkins yükleme kısmını tamamladık. Gelelim jenkins yönetim ekranına.

---

# 🎯 Jenkins Yönetim ?

* Sunucumuzun oluştuğu ekranı açalım.

<img src="jenkins10">

* Bu kısımda iki tane IP adresi var. Bunlardan kısaca bahsedelim
* Internal IP : Makinenizin Google Cloud ağındaki yerel IP adresidir. Bu IP adresi, yalnızca Google Cloud ağındaki diğer
  kaynaklarla iletişim kurmak için kullanılabilir ve internete erişim sağlamak için kullanılamaz.
* External IP : Makinenizin internet üzerinden erişilebilir genel IP adresidir.Bu IP adresi, makinenize internet
  üzerinden erişim sağlamak için kullanılır ve internetteki diğer kaynaklarla iletişim kurmak için kullanılır.
* Bu kısmıda öğrendiğimize göre bir tane browser açalım ve External IP:8080 adresine bağlanalım.

## 📌 Jenkins Yapılandırma

* External IP:8080 adresine girdiğimiz zaman önümüze bir ekran geliyor ve key istiyor.

<img src="jenkins11">

* Bu key'i almak için SSH tekrardan girelim.

```shell
docker ps 
```

* docker ps çekelim.

```shell
docker logs -f containerId 
```

* container'ımızın loglarına bakarsak şifreyi görebiliriz.

<img src="jenkins12">

<img src="jenkins13">

<img src="jenkins14">

* Tamamlanmasını bekleyelim.

<img src="jenkins15">

* Instance Configuration sayfasında direk save and finish kısmına tıklayınız.

<img src="jenkins16">

* Artık yönetim sayfasını açmış oluyoruz.
