package se.fk.github.rimfrost.yrkanderoll.presentation;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Path;
import java.util.UUID;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.YrkanderollControllerApi;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.GetYrkanderollResponse;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Yrkanderoll;

@ApplicationScoped
@Path("/yrkanderoll/{yrkanderollId}")
public class YrkanderollController implements YrkanderollControllerApi
{
   @Override
   public GetYrkanderollResponse getYrkanderoll(UUID yrkanderollId)
   {
      Yrkanderoll yrkanderoll = new Yrkanderoll();
      yrkanderoll.setId(yrkanderollId);
      yrkanderoll.setVersion("1.0");
      yrkanderoll.setNamn("Sökande");

      GetYrkanderollResponse response = new GetYrkanderollResponse();
      response.setYrkanderoll(yrkanderoll);

      return response;
   }
}
