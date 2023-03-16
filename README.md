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

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins10.png">

* Bu kısımda iki tane IP adresi var. Bunlardan kısaca bahsedelim
* Internal IP : Makinenizin Google Cloud ağındaki yerel IP adresidir. Bu IP adresi, yalnızca Google Cloud ağındaki diğer
  kaynaklarla iletişim kurmak için kullanılabilir ve internete erişim sağlamak için kullanılamaz.
* External IP : Makinenizin internet üzerinden erişilebilir genel IP adresidir.Bu IP adresi, makinenize internet
  üzerinden erişim sağlamak için kullanılır ve internetteki diğer kaynaklarla iletişim kurmak için kullanılır.
* Bu kısmıda öğrendiğimize göre bir tane browser açalım ve External IP:8080 adresine bağlanalım.

## 📌 Jenkins Yapılandırma

* External IP:8080 adresine girdiğimiz zaman önümüze bir ekran geliyor ve key istiyor.

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins11.png">

* Bu key'i almak için SSH tekrardan girelim.

```shell
docker ps 
```

* docker ps çekelim.

```shell
docker logs -f containerId 
```

* container'ımızın loglarına bakarsak şifreyi görebiliriz.

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins12.png">

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins13.png">

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins14.png">

* Tamamlanmasını bekleyelim.

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins15.png">

* Instance Configuration sayfasında direk save and finish kısmına tıklayınız.

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins16.png">

* Artık yönetim sayfasını açmış oluyoruz.

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins17.png">

* Şimdi bu kısımda Kontrol Merkezi > Jenkins'i Yönet > Plugin Manager > Available Plugins kısmından Maven
  Integration, Pipeline Maven Integration , Pipeline Utility Steps ,Docker , Docker Commons , Docker Pipeline ,
  docker-build-step kısımlarını indirip sunucuya restart atıyoruz.

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins18.png">

* Bu adımıda tamamladığımıza göre şimdi yeni bir öge oluşturalım.

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins19.png">

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins20.png">

* Açılan sayfada şu adımları doldurup seçiyoruz.

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins21.png">

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins22.png">

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins23.png">

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins24.png">

* Bu alanda jenkinsfile dosyasını kendi repomuzdan alması için bunu seçiyoruz.

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins25.png">

* Projemizin url'ini veriyoruz.
* Daha sonra add kısmına basıp jenkins'i seçiyoruz ve önümüze Jenkins Credentials Provider: Jenkins ekranı geliyor.

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins26.png">

* Bu kısımda github bilgilerimizi giriyoruz. Önerim password kısmına bir token girmeniz. Bu adımları izleyerek
  yapabilirsiniz.
* Önce github sayfasına giriş yapalım
* Ardından ayarlar kısmını açalım ve en alt da developer setting kısmına tıklayalım.

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins27.png">

* Token kısmından gerkli izinleri vererek oluşturun ve size bir token verecektir, onu password kısmına yapıştırın.

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins28.png">

* Hangi brach deyseniz onu seçin. Script Path seçin ve kaydet kısmına tıklayın.
* Son bir adımımız kaldı o da docker hesabını bağlamak.

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins29.png">

* Bu adımları izleyerek bir credentials oluşturun ve karşınıza şu ekran gelecek.

<img src="https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP/blob/master/image/jenkins30.png">

* Aynı github kısmı gibi password kısmını token oluşturarak verin.

---

* Jenkins yapılandırma kısmı bitti. Şimdi benim oluşturduğum Jenkinsfile dosyasına bakalım.

---

# 🎯 Jenkinsfile ?

```text
pipeline {
    agent any
    stages {
        stage('Build Maven') {
           agent {
             docker {
               image 'maven:3.8.5-openjdk-17'
               args '-v $HOME/.m2:/root/.m2'
               reuseNode true
             }
           }
           steps {
                 checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'rasitesdmr', url: 'https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP.git']])
                 sh 'mvn clean package -DskipTests'
           }
        }
        stage("Docker Build Image"){
            steps{
                script{
                    withCredentials([usernameColonPassword(credentialsId: 'docker', variable: 'dockerhub')]) {
                       sh 'docker build -t rasitesdmr1486/springboot-jenkins-gcp:latest .'
                    }

                }

            }

        }
        stage("Docker Push Image"){
            steps{
                script{
                    withDockerRegistry(credentialsId: 'docker', toolName: 'docker', url: "" ){
                       sh 'docker tag rasitesdmr1486/springboot-jenkins-gcp:latest  rasitesdmr1486/springboot-jenkins-gcp:latest'
                       sh 'docker push rasitesdmr1486/springboot-jenkins-gcp:latest'
                    }

                }

            }

        }

        stage("Docker Compose"){
           steps{
                 sh 'docker-compose up -d'
           }
        }

    }
}

```

* İlk başta maven image indiriyoruz.
* Projeyi github'dan çekiyoruz ve build edip jar dosyası haline getiriyoruz.
* Docker Hub'a push'ladıktan sonra sunucumuzda çalışan container'ımızı yeniden başlatıyoruz.
* Böylece proje hep güncel kalıyor.

---

* Şu kısma değinmek istiyorum. Diyelimki projeye birşeyler ekledik ve commit push yaparak github'a gönderdik. Jenkins
  bunu otomatik yapması için github projenin ayarlar kısmınnda Webhooks açmamız gerekiyor. Gelin bu adımlara bakalım.

---

## 📌 Webhooks

<img src="jenkins31">

<img src="jenkins32">

* Artık github'a push yaptığınızda jenkins otomatik tetiklenecektir.

# 🎯 Projenin Tamamlanması

* SSH sunucuya bağlanıyoruz.
* docker ps çekerek projem ayaktamı ona bakıyorum.

<img src="jenkins33">

* Projemde swagger kullanıyorum. Gelin swagger dan bakalım.

<img src="jenkins34">

* Gördüğümüz gibi sadece bir tane metodum var.
* Projeme öğrencilerin listesini çekmek için bir metot ekleyip github'a push'layacam ve ardından neler gerçekleşiyor
  onlara bakalım.
* 
