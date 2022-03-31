# PAO_LAB_2022
PRIMA ETAPA A PROIECTULUI:

Scopul acestui proiectul este de a tine evidenta unor service-uri auto. Pentru a face acest lucru, am creat urmatoarele clase: 

Service - care are date despre service-ul auto
Job - ofera detalii despre diferitele job-uri din cadrul unui service auto
Angajat - contine informatii despre angajatii service-urilor
Mecanic - mosteneste clasa Angajat
Piesa - informatii despre diferite piese auto
Cutie_de_viteze - mosteneste clasa Piese
Preturi - detalii despre preturile pieselor auto si manopera 
Programare - informatii despre programarile facute pentru un anumit service
Reducere - interfata, mostenita de clasa Preturi in care se calculeaza discount-uri pentru diferite piese si manopere

Pentru toate aceste clase am creat si repository-uri care mostenesc interfata GenericRepository, in care se pot adauga, cauta dupa id, face update-uri si sterge obiectele create din respectivele clase.
Pentru clasele Angajat, Piesa si Service am create si servicii (care faciliteaza implementarea actiunilor din meniul interactiv pentru aceste clase).
Am realizat si o clasa simpla de exceptii (InvalidDataException), care ajuta la tratarea exceptiilor pentru input-uri invalide.

Am creat si un meniu interactiv in care se pot adauga service-uri, angajati, piese, joburi, se pot afisa diferite aspecte despre aceastea si filtra in functie de input.
