# Weather API

This a Weather API application related
to [DefineX Java Spring Practicum](https://cohorts.patika.dev/cohortDetails/definex-java-spring-practicum/events) hosted
in [Patika.dev](https://patika.dev/).

## Content

Make a weather API. There are lots of free APIs on the internet for this.

We have included some API websites below. You can use other APIs if you wish.
https://openweathermap.org/api
https://www.weatherapi.com/
https://weatherstack.com/

The main goal is to write an API to communicate with these APIs.

Let's show the daily, weekly and monthly weather report according to the country / city information that we will get
from the user.

The request will first come to the API you will write, then after you receive the request, you will request the Free
Weather APIs and return this information.

You can use the very easy to use RestTemplate class for this process.

### What is expected:

- Extracting a correct API structure.
- Making validations on your model or parameters.
- Exception handling operations.

### Documentation

You can access the documentation of this API using this link after
run `mvn spring-boot:run` http://localhost:8080/swagger-ui/#/