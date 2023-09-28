[java]: https://img.shields.io/badge/java-v17-blue
[gson]: https://img.shields.io/badge/gson-v2.10.1-blue
[okhttp]: https://img.shields.io/badge/okhttp-v4.2.2-blue
[jsoup]: https://img.shields.io/badge/jsoup-v1.16.1-blue
[postgresql]: https://img.shields.io/badge/postgresql-v42.6.0-blue
[hibernate]: https://img.shields.io/badge/hibernate--core-v6.2.4.Final-blue
[lombok]: https://img.shields.io/badge/lombok-v1.18.28-blue
[junit-jupiter]: https://img.shields.io/badge/junit-v5.9.1-blue





<div align="center">
    <h1>Dat3-SP2</h1>
    <h2>Weather Data Enrichment and Storage</h2>
</div>
    
<img src="https://fpaw.aero/sites/default/files/iStock-184857129-home-crop_3.jpg" alt="https://fpaw.aero/sites/default/files/iStock-184857129-home-crop_3.jpg">


[![java][]]() 
[![gson][]]()
[![okhttp][]]()
[![jsoup][]]()
[![postgresql][]]()
[![hibernate][]]()
[![lombok][]]()
[![junit-jupiter][]]()


### Group:
* Sebastian Klitte Egeberg - Github: **[Sebbedeb](https://github.com/Sebbedeb)**
* Lasse Baggesgård Hansen - Github: **[kotteletfisk](https://github.com/kotteletfisk)**
* Oskar Daniel Olsen - Github: **[cph-oo221](https://github.com/cph-oo221)**


### EER Diagram:
![](documentation/EER_Diagram.png)


### Links:
API:
- We have used the API from: https://vejr.eu/pages/api-documentation - to enrich our data with extra information.

Web scraping:
- We have used web scraping to get the weather forecast from https://www.yr.no/nb

### Conclusion:
We ended up with two applications: one (Data-SP2) that runs on a droplet and collects data with web scraping and APIs, and another one, "WeatherWeb-SP2," that has the business logic. This one uses Tomcat and Java servlets to serve the data to the frontend, where we display all the weather data. We did not have time to make it a single application.