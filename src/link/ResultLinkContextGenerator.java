package link;
/**
 * Generate result specific context data{@link LinkContext} 
 * 
 * @author Dilendra Sajini
 *
 * @since Dec 29, 2021
 */
//public class ResultLinkContextGenerator implements LinkContextGenerator
//{
//  private List<ClientResult> clientResults;
//
//  public ResultLinkContextGenerator(List<ClientResult> clientResults)
//  {
//    this.clientResults = clientResults;
//  }
//
//  @Override
//  public LinkContext generate()
//  {
//    LinkContext linkContext = new LinkContext();
//    if (clientResults != null && !clientResults.isEmpty())
//    {
//      // assume that all client results related to single speciality.
//      // single row selection for the report cannot contain multiple speciality results.
//      int specialityNumber = clientResults.get(0).getSpeciality();
//      linkContext.setType(LinkContextType.RESULT);
//      linkContext.setSpeciality(specialityNumber);
//      linkContext.setArguments(getArguments(clientResults));
//      linkContext.setResourceString(getResourceString());
//    }
//    return linkContext;
//  }
//
//  protected String[] getArguments(List<ClientResult> clientResults)
//  {
//    List<String> arguments = clientResults.stream().map(ClientResult::getID).collect(Collectors.toList());
//    return arguments.toArray(new String[0]);
//  }
//
//  /**
//   * Resource string value specific to bundle.
//   * Use to generate ReferenceName in link data {@link LinkData}.
//   * @return String
//   */
//  protected String getResourceString()
//  {
//    String resourceString = LanguageToolkit.getResourceBundle(RoSConstants.LANGUAGE_RESULT_INBOX, true)
//        .getResourceString("NewMessageReferece.rr");
//    if (clientResults != null && !clientResults.isEmpty())
//    {
//      String resultTestTime = clientResults.get(0).getTestTimeActual();
//      return resourceString + LinkUtils.getSuffixDateString(resultTestTime);
//    }
//    return resourceString;
//  }
//
//}
