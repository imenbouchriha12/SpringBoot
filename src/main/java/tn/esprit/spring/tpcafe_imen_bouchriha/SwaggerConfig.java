package tn.esprit.spring.tpcafe_imen_bouchriha;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("TPCafe_Imen_Bouchriha") // ✅ Nom de ton projet
                        .description("TP Café Étude de Cas - Réalisée par Imen Bouchriha")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("imen bouchriha")
                                .email("imen.bouchriha@esprit.tn")
                                ) // lien mailto
                        .license(new License()
                                .name("Imen Bouchriha LinkedIn")
                                .url("https://www.linkedin.com/in/bouchriha-imen-99077823b/")));
    }


    @Bean
    public GroupedOpenApi allApis() {
        return GroupedOpenApi.builder()
                .group("All Management API")
                .pathsToMatch("/**")
                .build();
    }


    @Bean
    public GroupedOpenApi articleApi() {
        return GroupedOpenApi.builder()
                .group("Only Article Management API")
                .pathsToMatch("/articles/**")
                .build();
    }

    @Bean
    public GroupedOpenApi commandeApi() {
        return GroupedOpenApi.builder()
                .group("Only Commande Management API")
                .pathsToMatch("/commandes/**")
                .build();
    }
    @Bean
    public GroupedOpenApi adresseApi() {
        return GroupedOpenApi.builder()
                .group("Only Adresse Management API")
                .pathsToMatch("/adresses/**")
                .build();
    }
    @Bean
    public GroupedOpenApi carteFApi() {
        return GroupedOpenApi.builder()
                .group("Only Carte Fidility Management API")
                .pathsToMatch("/cartesF/**")
                .build();
    }
    @Bean
    public GroupedOpenApi clientApi() {
        return GroupedOpenApi.builder()
                .group("Only Client Management API")
                .pathsToMatch("/clients/**")
                .build();
    }
    @Bean
    public GroupedOpenApi detailsApi() {
        return GroupedOpenApi.builder()
                .group("Only Details Commande Management API")
                .pathsToMatch("/detailsCommandes/**")
                .build();
    }
    @Bean
    public GroupedOpenApi promotionApi() {
        return GroupedOpenApi.builder()
                .group("Only Promotion Management API")
                .pathsToMatch("/promotions/**")
                .build();
    }

}
