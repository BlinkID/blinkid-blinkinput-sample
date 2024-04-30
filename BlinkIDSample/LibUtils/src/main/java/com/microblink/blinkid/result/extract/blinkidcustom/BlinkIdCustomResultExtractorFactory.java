package com.microblink.blinkid.result.extract.blinkidcustom;

import com.microblink.blinkid.entities.recognizers.blinkbarcode.usdl.UsdlRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkbarcode.vin.VinRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkcard.BlinkCardRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkcard.legacy.LegacyBlinkCardEliteRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkcard.legacy.LegacyBlinkCardRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.australia.AustraliaDlBackRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.australia.AustraliaDlFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.austria.AustriaCombinedRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.austria.AustriaDlFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.austria.AustriaIdBackRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.austria.AustriaIdFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.austria.AustriaPassportRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.belgium.BelgiumCombinedRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.belgium.BelgiumIdBackRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.belgium.BelgiumIdFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.brunei.BruneiIdBackRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.brunei.BruneiIdFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.brunei.BruneiMilitaryIdBackRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.brunei.BruneiMilitaryIdFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.brunei.BruneiResidencePermitBackRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.brunei.BruneiResidencePermitFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.brunei.BruneiTemporaryResidencePermitBackRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.brunei.BruneiTemporaryResidencePermitFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.colombia.ColombiaDlFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.colombia.ColombiaIdBackRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.colombia.ColombiaIdFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.croatia.CroatiaCombinedRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.croatia.CroatiaIdBackRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.croatia.CroatiaIdFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.cyprus.CyprusIdBackRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.cyprus.CyprusIdFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.cyprus.CyprusOldIdBackRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.cyprus.CyprusOldIdFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.czechia.CzechiaCombinedRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.czechia.CzechiaIdBackRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.czechia.CzechiaIdFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.documentface.DocumentFaceRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.egypt.EgyptIdFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.eudl.EudlRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.BlinkIdMultiSideRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.generic.BlinkIdSingleSideRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.germany.GermanyCombinedRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.germany.GermanyDlFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.germany.GermanyIdBackRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.germany.GermanyIdFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.germany.GermanyIdOldRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.germany.GermanyPassportRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.hongkong.HongKongIdFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.idbarcode.IdBarcodeRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.indonesia.IndonesiaIdFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.ireland.IrelandDlFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.italy.ItalyDlFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.jordan.JordanCombinedRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.jordan.JordanIdBackRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.jordan.JordanIdFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.kuwait.KuwaitIdBackRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.kuwait.KuwaitIdFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.malaysia.MalaysiaDlFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.malaysia.MalaysiaIkadFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.malaysia.MalaysiaMyKadBackRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.malaysia.MalaysiaMyKadFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.malaysia.MalaysiaMyKasFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.malaysia.MalaysiaMyPrFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.malaysia.MalaysiaMyTenteraFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.mexico.MexicoVoterIdFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.morocco.MoroccoIdBackRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.morocco.MoroccoIdFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.mrtd.MrtdCombinedRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.mrtd.MrtdRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.newzealand.NewZealandDlFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.nigeria.NigeriaCombinedRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.nigeria.NigeriaVoterIdBackRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.passport.PassportRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.poland.PolandCombinedRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.poland.PolandIdBackRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.poland.PolandIdFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.romania.RomaniaIdFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.singapore.SingaporeCombinedRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.singapore.SingaporeDlFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.singapore.SingaporeIdBackRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.singapore.SingaporeIdFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.slovakia.SlovakiaCombinedRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.slovakia.SlovakiaIdBackRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.slovakia.SlovakiaIdFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.slovenia.SloveniaCombinedRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.slovenia.SloveniaIdBackRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.slovenia.SloveniaIdFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.spain.SpainDlFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.sweden.SwedenDlFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.switzerland.SwitzerlandDlFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.switzerland.SwitzerlandIdBackRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.switzerland.SwitzerlandIdFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.switzerland.SwitzerlandPassportRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesDlFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesIdBackRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesIdFrontRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.usdl.UsdlCombinedRecognizer;
import com.microblink.blinkid.entities.recognizers.blinkid.visa.VisaRecognizer;
import com.microblink.blinkid.result.extract.blinkcard.BlinkCardRecognizerResultExtractor;
import com.microblink.blinkid.result.extract.blinkcard.LegacyBlinkCardEliteRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkcard.LegacyBlinkCardRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkid.documentface.DocumentFaceRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkid.generic.BlinkIdMultiSideRecognizerResultExtractor;
import com.microblink.blinkid.result.extract.blinkid.generic.BlinkIdSingleSideRecognizerResultExtractor;
import com.microblink.blinkid.result.extract.blinkid.idbarcode.IdBarcodeResultExtractor;
import com.microblink.blinkid.result.extract.blinkid.mrtd.MRTDCombinedRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkid.mrtd.MrtdRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkid.passport.PassportResultExtractor;
import com.microblink.blinkid.result.extract.blinkid.usdl.USDLCombinedResultExtractor;
import com.microblink.blinkid.result.extract.blinkid.visa.VisaRecognizerResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.australia.AustralianDLBackSideRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.australia.AustralianDLFrontSideRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.austria.AustriaDlFrontRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.austria.AustrianIDBackSideRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.austria.AustrianIDCombinedRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.austria.AustrianIDFrontSideRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.austria.AustrianPassportRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.belgium.BelgiumCombinedRecognizerResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.belgium.BelgiumIdBackRecognizerResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.belgium.BelgiumIdFrontRecognizerResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.brunei.BruneiIdBackRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.brunei.BruneiIdFrontRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.brunei.BruneiMilitaryIdBackRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.brunei.BruneiMilitaryIdFrontRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.brunei.BruneiResidencePermitBackRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.brunei.BruneiResidencePermitFrontRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.brunei.BruneiTemporaryResidencePermitBackRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.brunei.BruneiTemporaryResidencePermitFrontRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.colombia.ColombiaDlFrontRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.colombia.ColombiaIDBackRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.colombia.ColombiaIDFrontRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.croatia.CroatianIDBackSideRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.croatia.CroatianIDCombinedRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.croatia.CroatianIDFrontSideRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.cyprus.CyprusIdBackRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.cyprus.CyprusIdFrontRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.cyprus.CyprusOldIdBackRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.cyprus.CyprusOldIdFrontRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.czechia.CzechIDBackSideRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.czechia.CzechIDCombinedRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.czechia.CzechIDFrontSideRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.egypt.EgyptIDFrontRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.eudl.EUDriversLicenceRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.germany.GermanIDBackSideRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.germany.GermanIDCombinedRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.germany.GermanIDFrontSideRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.germany.GermanOldIDRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.germany.GermanPassportRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.germany.GermanyDlFrontSideRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.hongkong.HongKongIdFrontRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.indonesia.IndonesianIDFrontSideRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.ireland.IrelandDlFrontRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.italy.ItalyDlFrontRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.jordan.JordanIDBackRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.jordan.JordanIDCombinedRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.jordan.JordanIDFrontRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.kuwait.KuwaitIdBackRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.kuwait.KuwaitIdFrontRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.malaysia.MalaysiaDLFrontRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.malaysia.MalaysiaIKadFrontRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.malaysia.MalaysiaMyKadFrontRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.malaysia.MalaysiaMyKasFrontRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.malaysia.MalaysiaMyPrFrontRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.malaysia.MalaysiaMyTenteraRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.malaysia.MyKadBackRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.mexico.MexicoVoterIdFrontRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.morocco.MoroccoIdBackRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.morocco.MoroccoIdFrontRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.newzealand.NewZealandDLFrontSideRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.nigeria.NigeriaCombinedRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.nigeria.NigeriaVoterIdBackRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.poland.PolishIDBackSideRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.poland.PolishIDCombinedRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.poland.PolishIDFrontSideRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.romania.RomanianIDFrontSideRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.singapore.SingaporeCombinedRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.singapore.SingaporeDlFrontRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.singapore.SingaporeIDBackRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.singapore.SingaporeIdFrontRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.slovakia.SlovakIDBackSideRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.slovakia.SlovakIDCombinedRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.slovakia.SlovakIDFrontSideRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.slovenia.SlovenianIDBackSideRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.slovenia.SlovenianIDCombinedRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.slovenia.SlovenianIDFrontSideRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.spain.SpainDlFrontRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.sweden.SwedenDlFrontRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.switzerland.SwissDLFrontSideRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.switzerland.SwissIDBackSideRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.switzerland.SwissIDFrontSideRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.switzerland.SwissPassportRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.unitedArabEmirates.UnitedArabEmiratesDlFrontRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.unitedArabEmirates.UnitedArabEmiratesIDBackRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.unitedArabEmirates.UnitedArabEmiratesIDFrontRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkidcustom.vin.VinRecognitionResultExtractor;
import com.microblink.blinkid.result.extract.blinkinput.BlinkInputResultExtractorFactory;
import com.microblink.blinkid.result.extract.usdl.USDLResultExtractor;

public class BlinkIdCustomResultExtractorFactory extends BlinkInputResultExtractorFactory {

    @Override
    protected void addExtractors() {
        super.addExtractors();

        add(VinRecognizer.class,
                new VinRecognitionResultExtractor());
        add(UsdlRecognizer.class,
                new USDLResultExtractor());
        add(UsdlCombinedRecognizer.class,
                new USDLCombinedResultExtractor());
        add(AustraliaDlFrontRecognizer.class,
                new AustralianDLFrontSideRecognitionResultExtractor());
        add(AustraliaDlBackRecognizer.class,
                new AustralianDLBackSideRecognitionResultExtractor());
        add(AustriaDlFrontRecognizer.class,
                new AustriaDlFrontRecognitionResultExtractor());
        add(AustriaIdFrontRecognizer.class,
                new AustrianIDFrontSideRecognitionResultExtractor());
        add(AustriaIdBackRecognizer.class,
                new AustrianIDBackSideRecognitionResultExtractor());
        add(AustriaCombinedRecognizer.class,
                new AustrianIDCombinedRecognitionResultExtractor());
        add(AustriaPassportRecognizer.class,
                new AustrianPassportRecognitionResultExtractor());
        add(BelgiumIdFrontRecognizer.class,
                new BelgiumIdFrontRecognizerResultExtractor());
        add(BelgiumIdBackRecognizer.class,
                new BelgiumIdBackRecognizerResultExtractor());
        add(BelgiumCombinedRecognizer.class,
                new BelgiumCombinedRecognizerResultExtractor());
        add(BlinkIdSingleSideRecognizer.class,
                new BlinkIdSingleSideRecognizerResultExtractor());
        add(BlinkIdMultiSideRecognizer.class,
                new BlinkIdMultiSideRecognizerResultExtractor());
        add(BruneiIdFrontRecognizer.class,
                new BruneiIdFrontRecognitionResultExtractor());
        add(BruneiIdBackRecognizer.class,
                new BruneiIdBackRecognitionResultExtractor());
        add(BruneiResidencePermitFrontRecognizer.class,
                new BruneiResidencePermitFrontRecognitionResultExtractor());
        add(BruneiResidencePermitBackRecognizer.class,
                new BruneiResidencePermitBackRecognitionResultExtractor());
        add(BruneiTemporaryResidencePermitFrontRecognizer.class,
                new BruneiTemporaryResidencePermitFrontRecognitionResultExtractor());
        add(BruneiTemporaryResidencePermitBackRecognizer.class,
                new BruneiTemporaryResidencePermitBackRecognitionResultExtractor());
        add(BruneiMilitaryIdFrontRecognizer.class,
                new BruneiMilitaryIdFrontRecognitionResultExtractor());
        add(BruneiMilitaryIdBackRecognizer.class,
                new BruneiMilitaryIdBackRecognitionResultExtractor());
        add(CroatiaIdFrontRecognizer.class,
                new CroatianIDFrontSideRecognitionResultExtractor());
        add(CroatiaIdBackRecognizer.class,
                new CroatianIDBackSideRecognitionResultExtractor());
        add(CroatiaCombinedRecognizer.class,
                new CroatianIDCombinedRecognitionResultExtractor());
        add(CyprusIdFrontRecognizer.class,
                new CyprusIdFrontRecognitionResultExtractor());
        add(CyprusIdBackRecognizer.class,
                new CyprusIdBackRecognitionResultExtractor());
        add(CyprusOldIdBackRecognizer.class,
                new CyprusOldIdBackRecognitionResultExtractor());
        add(CyprusOldIdFrontRecognizer.class,
                new CyprusOldIdFrontRecognitionResultExtractor());
        add(CzechiaIdBackRecognizer.class,
                new CzechIDBackSideRecognitionResultExtractor());
        add(CzechiaIdFrontRecognizer.class,
                new CzechIDFrontSideRecognitionResultExtractor());
        add(CzechiaCombinedRecognizer.class,
                new CzechIDCombinedRecognitionResultExtractor());
        add(GermanyIdOldRecognizer.class,
                new GermanOldIDRecognitionResultExtractor());
        add(GermanyIdBackRecognizer.class,
                new GermanIDBackSideRecognitionResultExtractor());
        add(GermanyCombinedRecognizer.class,
                new GermanIDCombinedRecognitionResultExtractor());
        add(GermanyIdFrontRecognizer.class,
                new GermanIDFrontSideRecognitionResultExtractor());
        add(GermanyPassportRecognizer.class,
                new GermanPassportRecognitionResultExtractor());
        add(GermanyDlFrontRecognizer.class,
                new GermanyDlFrontSideRecognitionResultExtractor());
        add(IndonesiaIdFrontRecognizer.class,
                new IndonesianIDFrontSideRecognitionResultExtractor());
        add(IrelandDlFrontRecognizer.class,
                new IrelandDlFrontRecognitionResultExtractor());
        add(ItalyDlFrontRecognizer.class,
                new ItalyDlFrontRecognitionResultExtractor());
        add(JordanIdFrontRecognizer.class,
                new JordanIDFrontRecognitionResultExtractor());
        add(JordanIdBackRecognizer.class,
                new JordanIDBackRecognitionResultExtractor());
        add(JordanCombinedRecognizer.class,
                new JordanIDCombinedRecognitionResultExtractor());
        add(HongKongIdFrontRecognizer.class,
                new HongKongIdFrontRecognitionResultExtractor());
        add(ColombiaDlFrontRecognizer.class,
                new ColombiaDlFrontRecognitionResultExtractor());
        add(ColombiaIdFrontRecognizer.class,
                new ColombiaIDFrontRecognitionResultExtractor());
        add(ColombiaIdBackRecognizer.class,
                new ColombiaIDBackRecognitionResultExtractor());
        add(EgyptIdFrontRecognizer.class,
                new EgyptIDFrontRecognitionResultExtractor());
        add(MalaysiaDlFrontRecognizer.class,
                new MalaysiaDLFrontRecognitionResultExtractor());
        add(NewZealandDlFrontRecognizer.class,
                new NewZealandDLFrontSideRecognitionResultExtractor());
        add(SwitzerlandIdBackRecognizer.class,
                new SwissIDBackSideRecognitionResultExtractor());
        add(SwitzerlandPassportRecognizer.class,
                new SwissPassportRecognitionResultExtractor());
        add(SwitzerlandIdFrontRecognizer.class,
                new SwissIDFrontSideRecognitionResultExtractor());
        add(SwitzerlandDlFrontRecognizer.class,
                new SwissDLFrontSideRecognitionResultExtractor());
        add(EudlRecognizer.class,
                new EUDriversLicenceRecognitionResultExtractor());
        add(DocumentFaceRecognizer.class,
                new DocumentFaceRecognitionResultExtractor());
        add(MalaysiaMyKadFrontRecognizer.class,
                new MalaysiaMyKadFrontRecognitionResultExtractor());
        add(MalaysiaMyKadBackRecognizer.class,
                new MyKadBackRecognitionResultExtractor());
        add(MalaysiaMyTenteraFrontRecognizer.class,
                new MalaysiaMyTenteraRecognitionResultExtractor());
        add(MalaysiaMyPrFrontRecognizer.class,
                new MalaysiaMyPrFrontRecognitionResultExtractor());
        add(MalaysiaMyKasFrontRecognizer.class,
                new MalaysiaMyKasFrontRecognitionResultExtractor());
        add(MalaysiaIkadFrontRecognizer.class,
                new MalaysiaIKadFrontRecognitionResultExtractor());
        add(MexicoVoterIdFrontRecognizer.class,
                new MexicoVoterIdFrontRecognitionResultExtractor());
        add(MoroccoIdBackRecognizer.class,
                new MoroccoIdBackRecognitionResultExtractor());
        add(MoroccoIdFrontRecognizer.class,
                new MoroccoIdFrontRecognitionResultExtractor());
        add(BlinkCardRecognizer.class,
                new BlinkCardRecognizerResultExtractor());
        add(LegacyBlinkCardRecognizer.class,
                new LegacyBlinkCardRecognitionResultExtractor());
        add(LegacyBlinkCardEliteRecognizer.class,
                new LegacyBlinkCardEliteRecognitionResultExtractor());
        add(NigeriaVoterIdBackRecognizer.class,
                new NigeriaVoterIdBackRecognitionResultExtractor());
        add(NigeriaCombinedRecognizer.class,
                new NigeriaCombinedRecognitionResultExtractor());
        add(PassportRecognizer.class,
                new PassportResultExtractor());
        add(PolandIdBackRecognizer.class,
                new PolishIDBackSideRecognitionResultExtractor());
        add(PolandIdFrontRecognizer.class,
                new PolishIDFrontSideRecognitionResultExtractor());
        add(PolandCombinedRecognizer.class,
                new PolishIDCombinedRecognitionResultExtractor());
        add(SlovakiaIdBackRecognizer.class,
                new SlovakIDBackSideRecognitionResultExtractor());
        add(SlovakiaIdFrontRecognizer.class,
                new SlovakIDFrontSideRecognitionResultExtractor());
        add(SlovakiaCombinedRecognizer.class,
                new SlovakIDCombinedRecognitionResultExtractor());
        add(SloveniaIdFrontRecognizer.class,
                new SlovenianIDFrontSideRecognitionResultExtractor());
        add(SloveniaIdBackRecognizer.class,
                new SlovenianIDBackSideRecognitionResultExtractor());
        add(SloveniaCombinedRecognizer.class,
                new SlovenianIDCombinedRecognitionResultExtractor());
        add(SingaporeIdBackRecognizer.class,
                new SingaporeIDBackRecognitionResultExtractor());
        add(SingaporeIdFrontRecognizer.class,
                new SingaporeIdFrontRecognitionResultExtractor());
        add(SingaporeCombinedRecognizer.class,
                new SingaporeCombinedRecognitionResultExtractor());
        add(SingaporeDlFrontRecognizer.class,
                new SingaporeDlFrontRecognitionResultExtractor());
        add(SpainDlFrontRecognizer.class,
                new SpainDlFrontRecognitionResultExtractor());
        add(RomaniaIdFrontRecognizer.class,
                new RomanianIDFrontSideRecognitionResultExtractor());
        add(UnitedArabEmiratesIdFrontRecognizer.class,
                new UnitedArabEmiratesIDFrontRecognitionResultExtractor());
        add(UnitedArabEmiratesIdBackRecognizer.class,
                new UnitedArabEmiratesIDBackRecognitionResultExtractor());
        add(UnitedArabEmiratesDlFrontRecognizer.class,
                new UnitedArabEmiratesDlFrontRecognitionResultExtractor());
        add(VisaRecognizer.class,
                new VisaRecognizerResultExtractor());
        add(MrtdCombinedRecognizer.class,
                new MRTDCombinedRecognitionResultExtractor());
        add(MrtdRecognizer.class,
                new MrtdRecognitionResultExtractor());
        add(SwedenDlFrontRecognizer.class,
                new SwedenDlFrontRecognitionResultExtractor());
        add(KuwaitIdFrontRecognizer.class,
                new KuwaitIdFrontRecognitionResultExtractor());
        add(KuwaitIdBackRecognizer.class,
                new KuwaitIdBackRecognitionResultExtractor());
        add(IdBarcodeRecognizer.class,
                new IdBarcodeResultExtractor());
    }
}
