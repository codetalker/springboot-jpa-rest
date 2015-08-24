package demo;

import demo.customer.Customer;
import demo.customer.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
public class DemoApplicationTests {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void testSaveCustomer() throws Exception {

        Customer customer1 = new Customer("sejin", "kim");
        Customer customer2 = new Customer();

        customerRepository.save(customer1);

        customer2 = customerRepository.findOne(1L);

        assertThat(customer2.getFirstName(), is("sejin"));

        System.out.println(customer2);
    }
}
