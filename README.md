# Simple Spring Boot REST API of Customers

#### Modificações da API
  - Unificação do campo id da classe AbstractEntity para somente uma classe de entity Customer
  
  - Substituição de codigo Boliplate(getter,setter,tostrings,hash e equals) utilizando lombook para simplificação
  
  - Uso Dtos(Data Transfer Object) junto com dependência Validation para validar os dados antes de Cadastrar 
  e da dependência modelMapper para converter Dtos para Entindades é virce-versa
  
  - Adição da dependencia do Swagger para testar e documentar APIs
  
  - Novos endpoints para API(GetALLPageable,GetAllNoPageable,DeleteByIdCustomer,SaveCustomer,UpdateCustomer)
  
 ## Uso do Software Insomia para testar API
 ![2](https://user-images.githubusercontent.com/47387393/185498474-050f091f-4868-45f1-91bd-44333f095511.PNG)

 ## Uso do Swagger para testar e documentar APIs
  ![1](https://user-images.githubusercontent.com/47387393/185498465-41e30781-fb33-4d82-a953-89486d3f6364.PNG)
