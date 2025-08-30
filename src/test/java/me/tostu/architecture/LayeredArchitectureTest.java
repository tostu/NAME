package me.tostu.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "me.tostu")
public class LayeredArchitectureTest {

    @ArchTest
    static final ArchRule layered_architecture_is_respected =
            layeredArchitecture()
                    .consideringAllDependencies()
                    .layer("Domain").definedBy("me.tostu.domain..")
                    .layer("Application").definedBy("me.tostu.application..")
                    .layer("PrimaryAdapter").definedBy("me.tostu.adapter.primary..")
                    .layer("SecondaryAdapter").definedBy("me.tostu.adapter.secondary..")

                    // Domain is the core and must not depend on outer layers
                    .whereLayer("Domain").mayNotAccessAnyLayer()

                    // Application orchestrates domain and must not depend on adapters
                    .whereLayer("Application").mayOnlyAccessLayers("Domain")

                    // Adapters can access only inward layers (Application + Domain)
                    .whereLayer("PrimaryAdapter").mayOnlyAccessLayers("Application", "Domain")
                    .whereLayer("SecondaryAdapter").mayOnlyAccessLayers("Application", "Domain");
}
