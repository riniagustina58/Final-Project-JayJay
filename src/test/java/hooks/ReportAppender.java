package hooks;

import io.cucumber.java.AfterAll;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ReportAppender {
    @AfterAll
    public static void addGitHubActionsLink() {
        try {
            String githubRunUrl = System.getenv("GITHUB_SERVER_URL") + "/" +
                    System.getenv("GITHUB_REPOSITORY") + "/actions/runs/" +
                    System.getenv("GITHUB_RUN_ID");

            if (githubRunUrl.contains("null")) {
                System.err.println("Environment variables tidak ditemukan.");
                return;
            }

            Path reportPath = Paths.get("reports/cucumber.html");
            Files.createDirectories(reportPath.getParent());

            if (Files.exists(reportPath)) {
                String footer = "<p>Test executed from GitHub Actions: <a href='" +
                        githubRunUrl + "'>" + githubRunUrl + "</a></p>";
                Files.write(reportPath, footer.getBytes(), StandardOpenOption.APPEND);
                System.out.println("✅ Added GitHub Actions link to report.");
            } else {
                System.err.println("❌ Report not found at: " + reportPath.toAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
