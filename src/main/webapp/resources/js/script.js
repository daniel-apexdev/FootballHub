        //<![CDATA[
        let sidebarOpen = false;

        function toggleSidebar() {
            const sidebar = document.getElementById('sidebar');
            const overlay = document.getElementById('overlay');
            const menuBtn = document.getElementById('menuBtn');
            const mainContent = document.getElementById('mainContent');

            sidebarOpen = !sidebarOpen;

            if (sidebarOpen) {
                sidebar.classList.add('open');
                overlay.classList.add('active');
                menuBtn.classList.add('active');
                if (window.innerWidth > 768) {
                    mainContent.classList.add('shifted');
                }
            } else {
                closeSidebar();
            }
        }

        function closeSidebar() {
            const sidebar = document.getElementById('sidebar');
            const overlay = document.getElementById('overlay');
            const menuBtn = document.getElementById('menuBtn');
            const mainContent = document.getElementById('mainContent');

            sidebar.classList.remove('open');
            overlay.classList.remove('active');
            menuBtn.classList.remove('active');
            mainContent.classList.remove('shifted');
            sidebarOpen = false;
        }

        function showSearch() {
            // Implement search functionality
            const searchQuery = prompt('🔍 Search for teams, players, matches...');
            if (searchQuery) {
                alert(`Searching for: "${searchQuery}"\n\nResults:\n• Manchester United\n• Cristiano Ronaldo\n• Premier League Match`);
            }
        }

        function showNotifications() {
            alert('🔔 Recent Notifications:\n\n⚽ Liverpool vs Arsenal - Final: 2-1\n📰 Transfer News: Mbappe signs with Real Madrid\n📊 Weekly Report: Team performance up 15%\n🏆 Champions League draw announced\n⏰ Match reminder: Barcelona vs PSG in 2 hours');
        }

        function toggleUserMenu() {
            alert('👤 User Menu:\n\n• View Profile\n• Account Settings\n• Notification Preferences\n• Help & Support\n• Sign Out');
        }

        function quickAction() {
            alert('⚡ Quick Actions:\n\n• Add New Match\n• Register Player\n• Create Report\n• Send Notification\n• Schedule Meeting');
        }

        // Initialize
        window.addEventListener('load', function() {
            // Set active navigation based on current page
            const currentPath = window.location.pathname;
            const navItems = document.querySelectorAll('.nav-item');
            
            navItems.forEach(item => {
                item.classList.remove('active');
                const href = item.getAttribute('href');
                if (href && currentPath.includes(href)) {
                    item.classList.add('active');
                }
            });

            // Handle window resize
            window.addEventListener('resize', function() {
                if (window.innerWidth <= 768 && sidebarOpen) {
                    document.getElementById('mainContent').classList.remove('shifted');
                } else if (window.innerWidth > 768 && sidebarOpen) {
                    document.getElementById('mainContent').classList.add('shifted');
                }
            });

            // Close sidebar when clicking outside on mobile
            document.addEventListener('click', function(event) {
                const sidebar = document.getElementById('sidebar');
                const menuBtn = document.getElementById('menuBtn');
                
                if (sidebarOpen && window.innerWidth <= 768 && 
                    !sidebar.contains(event.target) && 
                    !menuBtn.contains(event.target)) {
                    closeSidebar();
                }
            });
        });
        //]]>
