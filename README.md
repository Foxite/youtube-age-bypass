I built this so that you could host it on www.youtube.example.com, and for any age-restricted video, replace youtube.com with youtube.example.com.

At some point my deployment started getting startup failures due to a dependency it wasn't able to pull, whatever that means in a deployment, and I didn't have time to fix it then, and I haven't bothered fixing it since.

This repository has automated CI and dependapot setup, but the unit tests are flaky as hell, meaning they sometimes fail, sometimes succeed. This is because youtube.
