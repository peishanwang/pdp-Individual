package edu.neu.ccs.cs5010;


import java.util.List;

/**
 * EmailGenerator is an abstract class used to generate using template and evaluator.
 */
public abstract class EmailGenerator implements IEmailGenerator{
  private static final String DATE = "Date";
  private static final String DEPARTURE_CITY = "departure-city";
  private static final String DESTINATION_CITY = "destination-city";
  private static final String EVENT = "event";
  IInputHandler parameters;

  /**
   * Constructor of EmailGenerator.
   * @param args input arguments
   */
  public EmailGenerator(String[] args) {
    parameters = new InputHandler(args);
  }

  /**
   * Main method to generate EmailGenerator subclass instance and generate emails.
   * @param args input arguments
   */
  public static void main(String[] args) {
    IEmailGenerator eg = new OutputEmailGenerator(args);
    eg.generateEmail();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void generateEmail() {
    IFlightInfo flightInfo = new FlightInfo(parameters);
    Template template = new Template(parameters.getTemplate());
    CustomerInfo customerInfo = new CustomerInfo(parameters.getCSVPath());

    IEvaluatorContainer ec = new EvaluatorContainer();
    ec.push(new DateEvaluator(DATE));
    ec.push(new KeyValueEvaluator(DEPARTURE_CITY, flightInfo.getDepartureCity()));
    ec.push(new KeyValueEvaluator(DESTINATION_CITY, flightInfo.getDestinationCity()));
    ec.push(new KeyValueEvaluator(EVENT, flightInfo.getEvent()));

    List<String> headers = customerInfo.getHeaders();
    while (customerInfo.hasNextCustomer()) {
      ec.push(new KeyValueEvaluator(headers, customerInfo.nextCustomer()));
      List<String> newEmail = template.toEmail(ec);
      ec.pop();
      handleNewEmail(newEmail);
    }

  }

  /**
   * Handle email using different ways.
   * @param list new email text.
   */
  abstract void handleNewEmail(List<String> list);

}
